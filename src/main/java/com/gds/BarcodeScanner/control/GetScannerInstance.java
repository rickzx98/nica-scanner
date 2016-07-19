package com.gds.BarcodeScanner.control;

import jpos.Scanner;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class GetScannerInstance {

    private static Scanner scanner;

    public Scanner execute() {
        return createScannerInstance();
    }

    private Scanner createScannerInstance() {
        if (scanner == null) {
            scanner = new Scanner();
        }
        return scanner;
    }
}
