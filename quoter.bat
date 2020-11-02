@echo off
REM TODO: Check if command works

if "%~1"=="-h" (goto help)
if "%~1"=="-g" (goto generate)
goto run

:help
  echo "usage: ./quoter [OPTIONS]"
  echo " -i,--input <arg>          input file path"
  echo " -o,--output <arg>         output file path"
  echo " -s,--stdout               output to stdout"
  echo " -f,--formatter <arg>      formatter name (none,default,variable)"
  echo " -u,--use-template <arg>   whether to use template (true/false)"
  echo " -t,--template <arg>       template to use (applicable only if use template is true)"
  echo " -p,--position <arg>       tab position to start (applicable only if use template is true)"
  goto quit

:generate
  cd scripts
  python generate.py
  cd ..
  goto quit

:run
  gradlew.bat quoter -q -Pprops="%*"
  goto quit

:quit
