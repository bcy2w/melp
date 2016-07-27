
set ORIG_DIR=%CD%
cd %~dp0/..

java -jar lib/melp.jar

cd /d %ORIG_DIR%
