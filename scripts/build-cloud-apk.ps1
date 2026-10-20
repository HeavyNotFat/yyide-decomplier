<#
.SYNOPSIS
    Build a cloud-controller APK: every api.yyide.com / weather / book URL is
    rewritten to your local cloud controller.

.DESCRIPTION
    Works on the restored APK (recommended) or a stock 3.0.15 APK. Only the dex
    files that actually contain the URLs are disassembled, patched and
    reassembled, so the build takes a few seconds instead of minutes.

.EXAMPLE
    .\scripts\build-cloud-apk.ps1 -CloudUrl "http://10.0.2.2:8765"
#>
param(
    [string]$BaseApk = '',
    [string]$CloudUrl = 'http://10.0.2.2:8765',
    [string]$OutApk = '',
    [string]$SmaliHome = '',
    [switch]$SkipDownload
)

$ErrorActionPreference = 'Stop'
$root = Split-Path -Parent $PSScriptRoot
Set-Location $root

$CloudUrl = $CloudUrl.TrimEnd('/')
if ($CloudUrl -notmatch '^https?://') {
    throw 'CloudUrl 必须以 http:// 或 https:// 开头'
}

$jdk = if ($env:JAVA_HOME) { $env:JAVA_HOME } else { 'D:\java-se-17\jdk-17.0.20.1+1' }
$java = Join-Path $jdk 'bin\java.exe'
$keytool = Join-Path $jdk 'bin\keytool.exe'
$sdk = if ($env:ANDROID_HOME) { $env:ANDROID_HOME } elseif ($env:ANDROID_SDK_ROOT) { $env:ANDROID_SDK_ROOT } else { 'D:\Android SDK' }
$buildToolsRoot = Join-Path $sdk 'build-tools'
$buildTools = Get-ChildItem $buildToolsRoot -Directory -ErrorAction SilentlyContinue |
    Sort-Object { [version]$_.Name } -Descending | Select-Object -First 1
if (-not $buildTools) { throw "找不到 Android build-tools: $buildToolsRoot" }
$buildTools = $buildTools.FullName
$zipalign = Join-Path $buildTools 'zipalign.exe'
$apksigner = Join-Path $buildTools 'apksigner.bat'
$debugKeystore = Join-Path $env:USERPROFILE '.android\debug.keystore'

if (-not $BaseApk) {
    $candidates = @(
        (Join-Path $root 'dist\智慧班牌-3.0.15-还原版.apk'),
        (Join-Path $root 'dist\智慧班牌-3.0.15-原版签名.apk'),
        'D:\Desktop\反编译\文件\智慧班牌\智慧班牌_3.0.15.apk'
    )
    foreach ($candidate in $candidates) {
        if (Test-Path -LiteralPath $candidate) { $BaseApk = $candidate; break }
    }
}
if (-not $BaseApk -or -not (Test-Path -LiteralPath $BaseApk)) {
    throw '找不到基础 APK。请用 -BaseApk 指定 3.0.15 还原版或原版安装包。'
}
if (-not $OutApk) { $OutApk = Join-Path $root 'dist\智慧班牌-3.0.15-云端版.apk' }

foreach ($tool in @($java, $zipalign, $apksigner)) {
    if (-not (Test-Path -LiteralPath $tool)) { throw "缺少工具: $tool" }
}

# ---- smali toolchain ------------------------------------------------------
if (-not $SmaliHome) { $SmaliHome = Join-Path $root 'build\smali' }
New-Item -ItemType Directory -Force -Path $SmaliHome | Out-Null
$jars = @(
    @{ Name = 'baksmali-2.5.2.jar'; Url = 'https://repo1.maven.org/maven2/org/smali/baksmali/2.5.2/baksmali-2.5.2.jar' },
    @{ Name = 'smali-2.5.2.jar'; Url = 'https://repo1.maven.org/maven2/org/smali/smali/2.5.2/smali-2.5.2.jar' },
    @{ Name = 'dexlib2-2.5.2.jar'; Url = 'https://repo1.maven.org/maven2/org/smali/dexlib2/2.5.2/dexlib2-2.5.2.jar' },
    @{ Name = 'util-2.5.2.jar'; Url = 'https://repo1.maven.org/maven2/org/smali/util/2.5.2/util-2.5.2.jar' },
    @{ Name = 'guava-27.1-android.jar'; Url = 'https://repo1.maven.org/maven2/com/google/guava/guava/27.1-android/guava-27.1-android.jar' },
    @{ Name = 'jcommander-1.64.jar'; Url = 'https://repo1.maven.org/maven2/com/beust/jcommander/1.64/jcommander-1.64.jar' },
    @{ Name = 'antlr-runtime-3.5.2.jar'; Url = 'https://repo1.maven.org/maven2/org/antlr/antlr-runtime/3.5.2/antlr-runtime-3.5.2.jar' },
    @{ Name = 'antlr-3.5.2.jar'; Url = 'https://repo1.maven.org/maven2/org/antlr/antlr/3.5.2/antlr-3.5.2.jar' }
)
foreach ($jar in $jars) {
    $path = Join-Path $SmaliHome $jar.Name
    if (-not (Test-Path -LiteralPath $path)) {
        if ($SkipDownload) { throw "缺少 $($jar.Name)，且指定了 -SkipDownload" }
        Write-Host "下载 $($jar.Name) ..."
        Invoke-WebRequest -Uri $jar.Url -OutFile $path -UseBasicParsing
    }
}
$classpath = ($jars | ForEach-Object { Join-Path $SmaliHome $_.Name }) -join ';'

if (-not (Test-Path -LiteralPath $debugKeystore)) {
    New-Item -ItemType Directory -Force -Path (Split-Path $debugKeystore) | Out-Null
    & $keytool -genkeypair -v -keystore $debugKeystore -storepass android -alias androiddebugkey -keypass android -keyalg RSA -keysize 2048 -validity 10000 -dname 'CN=Android Debug,O=Android,C=US' | Out-Null
}

# ---- work dirs ------------------------------------------------------------
$work = Join-Path $root 'build\cloud-apk'
$dexDir = Join-Path $work 'dex'
$smaliRoot = Join-Path $work 'smali'
$newDexDir = Join-Path $work 'new'
$unsigned = Join-Path $work 'cloud-unsigned.apk'
$aligned = Join-Path $work 'cloud-aligned.apk'
foreach ($dir in @($dexDir, $smaliRoot, $newDexDir)) {
    Remove-Item -Recurse -Force $dir -ErrorAction SilentlyContinue
    New-Item -ItemType Directory -Force -Path $dir | Out-Null
}

Write-Host '[1/5] 解包 dex'
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::OpenRead((Resolve-Path -LiteralPath $BaseApk))
try {
    foreach ($entry in $zip.Entries) {
        if ($entry.Name -match '^classes(\d*)\.dex$') {
            [System.IO.Compression.ZipFileExtensions]::ExtractToFile(
                $entry, (Join-Path $dexDir $entry.Name), $true)
        }
    }
} finally {
    $zip.Dispose()
}

$targets = @(
    'https://api.yyide.com',
    'https://zhwnlapi.etouch.cn',
    'https://open-lcs.libsaas.com.cn'
)
$replaceArgs = @()
$patchedCount = 0

Write-Host '[2/5] 查找并反汇编包含接口域名的 dex'
foreach ($dex in Get-ChildItem $dexDir -Filter '*.dex' | Sort-Object Name) {
    $text = [System.Text.Encoding]::ASCII.GetString([System.IO.File]::ReadAllBytes($dex.FullName))
    $hits = @($targets | Where-Object { $text.Contains($_) })
    if ($hits.Count -eq 0) { continue }

    Write-Host "  $($dex.Name) -> $($hits -join ', ')"
    $smaliDir = Join-Path $smaliRoot $dex.BaseName
    & $java -Xmx3g -cp $classpath org.jf.baksmali.Main d $dex.FullName -o $smaliDir
    if ($LASTEXITCODE -ne 0) { throw "baksmali failed: $($dex.Name)" }

    $args2 = @()
    foreach ($target in $hits) { $args2 += $target; $args2 += $CloudUrl }
    & python (Join-Path $root 'scripts\patch_smali_urls.py') $smaliDir @args2
    if ($LASTEXITCODE -ne 0) { throw "smali patch failed: $($dex.Name)" }

    $newDex = Join-Path $newDexDir $dex.Name
    & $java -Xmx3g -cp $classpath org.jf.smali.Main a $smaliDir -o $newDex
    if ($LASTEXITCODE -ne 0) { throw "smali assemble failed: $($dex.Name)" }
    $replaceArgs += "$($dex.Name)=$newDex"
    $patchedCount++
}
if ($patchedCount -eq 0) {
    throw '没有找到需要替换的接口域名（APK 可能已经指向本地）。'
}
Write-Host "  已重写 $patchedCount 个 dex -> $CloudUrl"

Write-Host '[3/5] 重打包 APK'
$pythonArgs = @((Join-Path $root 'scripts\repack_cloud.py'), $BaseApk, $unsigned) + $replaceArgs
& python @pythonArgs
if ($LASTEXITCODE -ne 0) { throw 'repack failed' }

Write-Host '[4/5] zipalign'
& $zipalign -f -p 4 $unsigned $aligned
if ($LASTEXITCODE -ne 0) { throw 'zipalign failed' }

Write-Host '[5/5] 签名'
New-Item -ItemType Directory -Force -Path (Split-Path $OutApk) | Out-Null
& $apksigner sign --ks $debugKeystore --ks-pass pass:android --key-pass pass:android --ks-key-alias androiddebugkey --out $OutApk $aligned
if ($LASTEXITCODE -ne 0) { throw 'apksigner failed' }
if (Test-Path -LiteralPath "$OutApk.idsig") { Remove-Item -LiteralPath "$OutApk.idsig" -Force }

$hash = (Get-FileHash -Algorithm SHA256 -LiteralPath $OutApk).Hash.ToLower()
$size = (Get-Item -LiteralPath $OutApk).Length
Write-Host ''
Write-Host "输出: $OutApk"
Write-Host "云端: $CloudUrl"
Write-Host "大小: $size bytes"
Write-Host "SHA-256: $hash"
