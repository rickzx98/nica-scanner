package com.gds.BarcodeScanner.boundary;

import com.gds.BarcodeScanner.control.*;
import com.gds.BarcodeScanner.control.listeners.CreateScannerDataListener;
import com.gds.BarcodeScanner.control.listeners.CreateScannerDirectIOListener;
import com.gds.BarcodeScanner.control.listeners.CreateScannerErrorListener;
import com.gds.BarcodeScanner.control.listeners.CreateScannerStatusUpdateListener;
import jpos.Scanner;
import jpos.events.DirectIOEvent;
import jpos.events.DirectIOListener;
import jpos.events.StatusUpdateEvent;
import jpos.events.StatusUpdateListener;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class BarcodeScanner {

    public void start() {
        new SetJposFilePath().execute();
        new InitDllLibraries().execute();
        Scanner scanner = new GetScannerInstance().execute();
        new OpenScanner().execute(scanner);
        new ClaimScanner().execute(scanner);
        new EnableScanner().execute(scanner);
        scanner.addDataListener(new CreateScannerDataListener().execute());
        scanner.addErrorListener(new CreateScannerErrorListener().execute());
        scanner.addDirectIOListener(new CreateScannerDirectIOListener().execute());
        scanner.addStatusUpdateListener(new CreateScannerStatusUpdateListener().execute());
    }

    public void stop() {
        Scanner scanner = new GetScannerInstance().execute();
        new DisableScanner().execute(scanner);
        new ReleaseScanner().execute(scanner);
    }

}
