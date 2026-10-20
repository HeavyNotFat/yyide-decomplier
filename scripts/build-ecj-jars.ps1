# Rebuild the source-compiled class jars used by the Gradle build.
#
#   powershell -ExecutionPolicy Bypass -File .\scripts\build-ecj-jars.ps1
#   powershell -ExecutionPolicy Bypass -File .\scripts\build-ecj-jars.ps1 -Check
#
# The decompiled sources contain constructs javac refuses to compile, so the
# app sources are compiled by Eclipse ECJ in error-recovery mode.  ECJ emits a
# few unreadable class files; StripAnnotations drops them, and the original
# 3.0.15 classes are used as a fallback for any class ECJ could not emit.

param(
    [string]$ProjectRoot = (Split-Path -Parent $PSScriptRoot),
    [switch]$Check
)

$ErrorActionPreference = 'Stop'
Add-Type -AssemblyName System.IO.Compression.FileSystem

$root = (Resolve-Path -LiteralPath $ProjectRoot).Path
$jdk = if ($env:ECJ_JDK) { $env:ECJ_JDK }
       elseif (Test-Path 'D:\java-se-17\jdk-17.0.20.1+1') { 'D:\java-se-17\jdk-17.0.20.1+1' }
       else { throw 'Set ECJ_JDK to a JDK 17 installation.' }
$androidJar = if ($env:ANDROID_JAR) { $env:ANDROID_JAR }
              elseif (Test-Path 'D:\Android SDK\platforms\android-31\android.jar') { 'D:\Android SDK\platforms\android-31\android.jar' }
              else { throw 'Set ANDROID_JAR to platforms\android-31\android.jar.' }

$java = Join-Path $jdk 'bin\java.exe'
$javac = Join-Path $jdk 'bin\javac.exe'
$jar = Join-Path $jdk 'bin\jar.exe'

$tools = Join-Path $root 'tools'
$libs = Join-Path $root 'libs'
$build = Join-Path $root 'build'
$ecj = Join-Path $tools 'ecj.jar'
$asm = Join-Path $tools 'asm-9.6.jar'
$asmCommon = Join-Path $tools 'asm-commons-9.6.jar'
$stripSrc = Join-Path $tools 'StripAnnotations.java'
$appSrc = Join-Path $root 'src\main\java'
$origJar = Join-Path $libs 'original-classes.jar'
$appR = Join-Path $libs 'app-r.jar'
$libJar = Join-Path $libs 'library-classes.jar'
$appJar = Join-Path $libs 'app-classes.jar'
$hybridJar = Join-Path $libs 'app-classes-hybrid.jar'
$supportJar = Join-Path $libs 'app-support-classes.jar'

$required = [ordered]@{
    'Project root'          = $root
    'Application sources'   = $appSrc
    'Original APK classes'  = $origJar
    'R class'               = $appR
    'Android SDK jar'       = $androidJar
    'JDK java.exe'          = $java
    'JDK javac.exe'         = $javac
    'ECJ compiler'          = $ecj
    'ASM'                   = $asm
    'ASM commons'           = $asmCommon
    'StripAnnotations.java' = $stripSrc
}
if ($Check) {
    $missing = $false
    foreach ($entry in $required.GetEnumerator()) {
        if ($entry.Value -and (Test-Path -LiteralPath $entry.Value)) {
            Write-Host ("OK       {0}: {1}" -f $entry.Key, $entry.Value)
        } else {
            Write-Host ("MISSING  {0}: {1}" -f $entry.Key, $entry.Value)
            $missing = $true
        }
    }
    if ($missing) { throw 'Some required inputs are missing.' }
    Write-Host 'All inputs found. No compilation was performed.'
    exit 0
}

foreach ($entry in $required.GetEnumerator()) {
    if (-not (Test-Path -LiteralPath $entry.Value)) { throw "Missing $($entry.Key): $($entry.Value)" }
}

function New-FilteredJar([string]$source, [string]$destination, [string]$excludePrefix) {
    if (Test-Path -LiteralPath $destination) { Remove-Item -Force $destination }
    $zin = [System.IO.Compression.ZipFile]::OpenRead($source)
    $zout = [System.IO.Compression.ZipFile]::Open($destination, [System.IO.Compression.ZipArchiveMode]::Create)
    $count = 0
    try {
        foreach ($entry in $zin.Entries) {
            if ($entry.FullName.StartsWith($excludePrefix)) { continue }
            $out = $zout.CreateEntry($entry.FullName, [System.IO.Compression.CompressionLevel]::Optimal)
            $inStream = $entry.Open()
            $outStream = $out.Open()
            try { $inStream.CopyTo($outStream) } finally { $outStream.Dispose(); $inStream.Dispose() }
            $count++
        }
    } finally {
        $zout.Dispose()
        $zin.Dispose()
    }
    Write-Host "Wrote $destination ($count entries)"
}

function Copy-Entry([System.IO.Compression.ZipArchive]$zin, [System.IO.Compression.ZipArchiveEntry]$entry, [System.IO.Compression.ZipArchive]$zout) {
    $out = $zout.CreateEntry($entry.FullName, [System.IO.Compression.CompressionLevel]::Optimal)
    $inStream = $entry.Open()
    $outStream = $out.Open()
    try { $inStream.CopyTo($outStream) } finally { $outStream.Dispose(); $inStream.Dispose() }
}

Write-Host '[1/4] library jar'
New-FilteredJar $origJar $libJar 'com/yd/android_brand_mvp/'

Write-Host '[2/4] ECJ compile'
$list = Join-Path $build 'app-sources.txt'
New-Item -ItemType Directory -Force -Path $build | Out-Null
$sources = Get-ChildItem -Path $appSrc -Recurse -Filter *.java | Where-Object { $_.Name -ne 'R.java' } | ForEach-Object { $_.FullName }
[System.IO.File]::WriteAllLines($list, $sources, (New-Object System.Text.UTF8Encoding($false)))
Write-Host "Application sources: $($sources.Count)"

$ecjOut = Join-Path $build 'ecj-app'
Remove-Item -Recurse -Force $ecjOut -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force -Path $ecjOut | Out-Null
$classpath = "$androidJar;$appR;$libJar"
if (Test-Path -LiteralPath $supportJar) { $classpath = "$classpath;$supportJar" }
$logPath = Join-Path $build 'ecj-app.log'
$previousEap = $ErrorActionPreference
$ErrorActionPreference = 'Continue'
& $java -Xmx8g -jar $ecj -1.8 -proceedOnError -nowarn -encoding UTF-8 -d $ecjOut -cp $classpath "@$list" 2>&1 | Out-File -FilePath $logPath -Encoding utf8
$ecjExit = $LASTEXITCODE
$ErrorActionPreference = $previousEap
Write-Host "ECJ exit: $ecjExit (errors are expected; classes are still written)"
Write-Host "ECJ classes: $((Get-ChildItem $ecjOut -Recurse -Filter *.class).Count)"

Write-Host '[3/4] strip annotations'
$rawJar = Join-Path $build 'app-classes-raw.jar'
if (Test-Path -LiteralPath $rawJar) { Remove-Item -Force $rawJar }
& $jar cf $rawJar -C $ecjOut .
if ($LASTEXITCODE -ne 0) { throw 'jar failed' }

$stripTool = Join-Path $build 'strip-tool'
New-Item -ItemType Directory -Force -Path $stripTool | Out-Null
& $javac -cp "$asm;$asmCommon" -d $stripTool $stripSrc
if ($LASTEXITCODE -ne 0) { throw 'failed to compile StripAnnotations' }
& $java -cp "$stripTool;$asm;$asmCommon" StripAnnotations $rawJar $appJar
if ($LASTEXITCODE -ne 0) { throw 'StripAnnotations failed' }
Write-Host "Wrote $appJar"

Write-Host '[4/4] hybrid fallback jar'
$temp = "$hybridJar.tmp"
if (Test-Path -LiteralPath $temp) { Remove-Item -Force $temp }
$zApp = [System.IO.Compression.ZipFile]::OpenRead($appJar)
$zOrig = [System.IO.Compression.ZipFile]::OpenRead($origJar)
$zOut = [System.IO.Compression.ZipFile]::Open($temp, [System.IO.Compression.ZipArchiveMode]::Create)
$have = New-Object 'System.Collections.Generic.HashSet[string]'
$added = 0
try {
    foreach ($entry in $zApp.Entries) {
        Copy-Entry $zApp $entry $zOut
        [void]$have.Add($entry.FullName)
    }
    foreach ($entry in $zOrig.Entries) {
        $name = $entry.FullName
        if (-not $name.StartsWith('com/yd/android_brand_mvp/')) { continue }
        if (-not $name.EndsWith('.class')) { continue }
        if ($name -eq 'com/yd/android_brand_mvp/R.class' -or $name.StartsWith('com/yd/android_brand_mvp/R$')) { continue }
        if ($have.Contains($name)) { continue }
        Copy-Entry $zOrig $entry $zOut
        [void]$have.Add($name)
        $added++
    }
    $styleable = 'com/yd/android_brand_mvp/R$styleable.class'
    if (-not $have.Contains($styleable)) {
        $zR = [System.IO.Compression.ZipFile]::OpenRead($appR)
        try {
            $entry = $zR.GetEntry($styleable)
            if ($entry) { Copy-Entry $zR $entry $zOut }
        } finally { $zR.Dispose() }
    }
} finally {
    $zOut.Dispose(); $zApp.Dispose(); $zOrig.Dispose()
}
Move-Item -Force $temp $hybridJar
Write-Host "Wrote $hybridJar (+$added fallback classes)"
Write-Host 'Done. Run .\gradlew.bat :assembleDebug'
