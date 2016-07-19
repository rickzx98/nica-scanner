package com.gds.BarcodeScanner.boundary;

import com.gds.BarcodeScanner.control.InitDllLibraries;
import com.gds.BarcodeScanner.control.GetScannerInstance;
import com.gds.BarcodeScanner.control.OpenScanner;
import com.gds.BarcodeScanner.control.SetJposFilePath;
import com.gds.BarcodeScanner.control.listeners.CreateScannerDataListener;
import jpos.Scanner;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class BarcodeScanner {

    public void start() {
        new SetJposFilePath().execute();
        new InitDllLibraries().execute();
        Scanner scanner = new GetScannerInstance().execute();
        scanner.addDataListener(new CreateScannerDataListener().execute());
        new OpenScanner().execute(scanner);
    }

}
