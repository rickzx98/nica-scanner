@echo off
call env.bat
java -jar -Djava.library.path=%NS_DLL_DIR% %NS_APP%
