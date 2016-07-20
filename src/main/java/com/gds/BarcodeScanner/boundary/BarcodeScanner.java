package com.gds.BarcodeScanner.boundary;

import com.gds.BarcodeScanner.control.*;
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
        new ClaimScanner().execute(scanner);
        new EnableScanner().execute(scanner);
    }

    public void stop() {
        Scanner scanner = new GetScannerInstance().execute();
        new DisableScanner().execute(scanner);
        new ReleaseScanner().execute(scanner);
    }

}
