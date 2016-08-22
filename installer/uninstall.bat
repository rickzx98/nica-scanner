@echo off
call env.bat
RMDIR /S /Q \nica-scanner
sc stop nica-scanner
sc delete nica-scanner