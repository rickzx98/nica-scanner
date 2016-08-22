@echo off
call env.bat
javaw -jar -Djava.library.path=%NS_DLL_DIR% %NS_APP%
