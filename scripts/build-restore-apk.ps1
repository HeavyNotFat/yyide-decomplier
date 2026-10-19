# Build the identity-patched 智慧班牌 restoration APK.
#
#   .\scripts\build-restore-apk.ps1
#   .\scripts\build-restore-apk.ps1 -BaseApk "D:\path\to\智慧班牌_3.0.14.apk"
#
# The script compiles the two patched Java classes, dexes them, inserts the
# patch dex as classes.dex, shifts the original dex files to classes2..N,
# zipaligns and signs with the Android debug keystore.

param(
    [string]$BaseApk = '',
    [string]$OutApk = ''
)

$ErrorActionPreference = 'Stop'
$root = Split-Path -Parent $PSScriptRoot
$sourceFiles = @(
    (Join-Path $root 'src\main\java\com\yd\android_brand_mvp\BaseApplication.java'),
    (Join-Path $root 'src\main\java\com\yd\android_brand_mvp\presenter\LoginPresenter.java'),
    (Join-Path $root 'src\main\java\com\yd\android_brand_mvp\verfity\RestoreVerificationRouter.java'),
    (Join-Path $root 'src\main\java\com\yd\android_brand_mvp\verfity\fragment\CardFragment3.java'),
    (Join-Path $root 'src\main\java\com\yd\android_brand_mvp\verfity\fragment\CardFragment4.java'),
    (Join-Path $root 'src\main\java\com\yd\android_brand_mvp\verfity\fragment\CardFragment.java'),
    (Join-Path $root 'src\main\java\com\yd\android_brand_mvp\verfity\fragment\VerificationCodeFragment.java')
)
$work = Join-Path $root 'build\restore-patch'
$patchClasses = Join-Path $work 'classes'
$patchJar = Join-Path $work 'patch-classes.jar'
$patchDexDir = Join-Path $work 'dex'
$patchDex = Join-Path $patchDexDir 'classes.dex'
$unsigned = Join-Path $work 'restore-unsigned.apk'
$aligned = Join-Path $work 'restore-aligned.apk'

$jdk = if ($env:JAVA_HOME) { $env:JAVA_HOME } else { 'D:\java-se-17\jdk-17.0.20.1+1' }
$javac = Join-Path $jdk 'bin\javac.exe'
$java = Join-Path $jdk 'bin\java.exe'
$jar = Join-Path $jdk 'bin\jar.exe'
$androidJar = 'D:\Android SDK\platforms\android-31\android.jar'
$buildTools = 'D:\Android SDK\build-tools\34.0.0'
$d8Jar = Join-Path $buildTools 'lib\d8.jar'
$zipalign = Join-Path $buildTools 'zipalign.exe'
$apksigner = Join-Path $buildTools 'apksigner.bat'
$originalJar = Join-Path $root 'libs\original-classes.jar'
$appR = Join-Path $root 'libs\app-r.jar'
$debugKeystore = Join-Path $env:USERPROFILE '.android\debug.keystore'

if (-not $BaseApk) {
    $candidates = @(
        (Join-Path $root 'dist\智慧班牌-3.0.14-原版签名.apk'),
        'D:\Desktop\反编译\文件\智慧班牌\智慧班牌_3.0.14.apk'
    )
    foreach ($candidate in $candidates) {
        if (Test-Path -LiteralPath $candidate) { $BaseApk = $candidate; break }
    }
}
if (-not $BaseApk -or -not (Test-Path -LiteralPath $BaseApk)) {
    throw '找不到原版 APK。请用 -BaseApk 指定 3.0.14 原版安装包。'
}
if (-not $OutApk) {
    $OutApk = Join-Path $root 'dist\智慧班牌-3.0.14-还原版.apk'
}

foreach ($tool in @($javac, $java, $jar, $androidJar, $d8Jar, $zipalign, $apksigner, $originalJar, $appR)) {
    if (-not (Test-Path -LiteralPath $tool)) { throw "缺少工具或依赖: $tool" }
}
if (-not (Test-Path -LiteralPath $debugKeystore)) {
    New-Item -ItemType Directory -Force -Path (Split-Path $debugKeystore) | Out-Null
    & (Join-Path $jdk 'bin\keytool.exe') -genkeypair -v -keystore $debugKeystore -storepass android `
        -alias androiddebugkey -keypass android -keyalg RSA -keysize 2048 -validity 10000 `
        -dname 'CN=Android Debug,O=Android,C=US' | Out-Null
}

Write-Host '[1/5] 编译补丁 Java 源码'
Remove-Item -Recurse -Force $work -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force -Path $patchClasses, $patchDexDir | Out-Null
foreach ($source in $sourceFiles) {
    if (-not (Test-Path -LiteralPath $source)) { throw "缺少补丁源码: $source" }
}
& $javac -source 8 -target 8 -encoding UTF-8 -cp "$androidJar;$appR;$originalJar" -d $patchClasses @sourceFiles
if ($LASTEXITCODE -ne 0) { throw 'javac failed' }

Write-Host '[2/5] 生成 patch dex'
& $jar cf $patchJar -C $patchClasses .
& $java -cp $d8Jar com.android.tools.r8.D8 --lib $androidJar --classpath $originalJar `
    --min-api 22 --output $patchDexDir $patchJar
if ($LASTEXITCODE -ne 0) { throw 'd8 failed' }

Write-Host '[3/5] 重打包原版 APK（patch dex 放在 classes.dex，原 dex 后移）'
New-Item -ItemType Directory -Force -Path (Split-Path $OutApk) | Out-Null
& python (Join-Path $root 'scripts\repack_restore.py') $BaseApk $patchDex $unsigned
if ($LASTEXITCODE -ne 0) { throw 'repack failed' }

Write-Host '[4/5] zipalign'
& $zipalign -f -p 4 $unsigned $aligned
if ($LASTEXITCODE -ne 0) { throw 'zipalign failed' }

Write-Host '[5/5] 签名'
& $apksigner sign --ks $debugKeystore --ks-pass pass:android --key-pass pass:android `
    --ks-key-alias androiddebugkey --out $OutApk $aligned
if ($LASTEXITCODE -ne 0) { throw 'apksigner failed' }

$hash = (Get-FileHash -Algorithm SHA256 -LiteralPath $OutApk).Hash.ToLower()
$size = (Get-Item -LiteralPath $OutApk).Length
Write-Host ''
Write-Host "输出: $OutApk"
Write-Host "大小: $size bytes"
Write-Host "SHA-256: $hash"
