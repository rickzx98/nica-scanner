@echo off
call env.bat
rmdir %NS_JPOS_DIR%
rmdir %NS_DLL_DIR%
rmdir %NS_LOGS_DIR%
rmdir  %NS_LIB_DIR%
rmdir %NS_ICON_DIR%
rmdir  %NS_BIN_DIR%
mkdir %NS_LOGS_DIR%
mkdir %NS_JPOS_DIR%
mkdir %NS_BIN_DIR%
mkdir %NS_LIB_DIR%
mkdir %NS_DLL_DIR%
mkdir %NS_ICON_DIR%
copy CSJPOSScanner64.dll %NS_DLL_DIR%
copy CSJPOSScanner.dll %NS_DLL_DIR%
copy jpos.xml %NS_JPOS_DIR%\jpos.xml
copy nica-scanner_lib\*.jar %NS_LIB_DIR%
copy *.* %NS_BIN_DIR%
copy jpos.properties %NS_JPOS_DIR%
copy app.properties %NS_BIN_DIR%
copy icon\*.* %NS_ICON_DIR%
sc create nica-scanner type= own start= auto binPath= "C:\nica-scanner\bin\nica-scanner.bat" DisplayName= "GDS Scanner Handler"