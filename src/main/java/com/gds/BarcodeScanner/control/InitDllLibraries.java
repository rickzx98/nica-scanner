package com.gds.BarcodeScanner.control;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class InitDllLibraries {

    public void execute() {
        System.loadLibrary(System.getenv("SCANNER_DLL_64"));
    }

}
