param(
    [string]$Out = "dist\智慧班牌-3.0.15-MOCK.apk"
)

$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $PSScriptRoot
Set-Location $root

$javaHome = if ($env:JAVA_HOME) { $env:JAVA_HOME } else { "D:\java-se-17\jdk-17.0.20.1+1" }
$java = Join-Path $javaHome "bin\java.exe"
$javac = Join-Path $javaHome "bin\javac.exe"
$sdk = "D:\Android SDK"
$androidJar = Join-Path $sdk "platforms\android-31\android.jar"
$d8Jar = Join-Path $sdk "build-tools\34.0.0\lib\d8.jar"
$zipalign = Join-Path $sdk "build-tools\34.0.0\zipalign.exe"
$apksigner = Join-Path $sdk "build-tools\34.0.0\apksigner.bat"
$apktool = Join-Path $root "build\apktool.jar"
$decoded = Join-Path $root "build\apktool-mock"
$portalSrc = Join-Path $root "mock-portal"
$keystore = Join-Path $env:USERPROFILE ".android\debug.keystore"

foreach ($p in @($java, $javac, $androidJar, $d8Jar, $zipalign, $apksigner, $apktool, $decoded, $keystore)) {
    if (-not (Test-Path $p)) { throw "missing: $p" }
}

$classesDir = Join-Path $root "build\mock-portal-classes"
$dexDir = Join-Path $root "build\mock-portal-dex"
$unsigned = Join-Path $root "build\mock-portal-unsigned.apk"
$aligned = Join-Path $root "build\mock-portal-aligned.apk"

Remove-Item $classesDir, $dexDir -Recurse -Force -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Path $classesDir, $dexDir | Out-Null

Write-Host "1/4 compile mock portal"
$sources = Get-ChildItem $portalSrc -Recurse -Filter *.java | ForEach-Object { $_.FullName }
& $javac -source 8 -target 8 -encoding UTF-8 -cp $androidJar -d $classesDir $sources
if ($LASTEXITCODE -ne 0) { throw "javac failed" }

Write-Host "2/4 dex"
$classFiles = Get-ChildItem $classesDir -Recurse -Filter *.class | ForEach-Object { $_.FullName }
& $java -cp $d8Jar com.android.tools.r8.D8 `
    --lib $androidJar --output $dexDir $classFiles
if ($LASTEXITCODE -ne 0) { throw "d8 failed" }

Write-Host "3/4 apktool build"
& $java -jar $apktool b $decoded -o $unsigned
if ($LASTEXITCODE -ne 0) { throw "apktool build failed" }

# Inject classes7.dex (mock portal / leave / manager).
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::Open($unsigned, "Update")
try {
    $old = $zip.GetEntry("classes7.dex")
    if ($old) { $old.Delete() }
    [System.IO.Compression.ZipFileExtensions]::CreateEntryFromFile(
        $zip, (Join-Path $dexDir "classes.dex"), "classes7.dex",
        [System.IO.Compression.CompressionLevel]::Optimal) | Out-Null
} finally {
    $zip.Dispose()
}

Write-Host "4/4 align + sign"
& $zipalign -f -p 4 $unsigned $aligned
& $apksigner sign --ks $keystore --ks-key-alias androiddebugkey `
    --ks-pass pass:android --key-pass pass:android --out (Join-Path $root $Out) $aligned
if ($LASTEXITCODE -ne 0) { throw "apksigner failed" }

Get-Item (Join-Path $root $Out) | Select-Object FullName, Length, LastWriteTime
