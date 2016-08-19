package com.gds.BarcodeScanner.control;

import com.gds.Common.control.GetAppProperty;
import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;

import jpos.JposException;
import jpos.Scanner;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class OpenScanner {
    private GetErrorLogger errorLogger = new GetErrorLogger();
    private GetInfoLogger infoLogger = new GetInfoLogger();

    public void execute(Scanner scanner) {
        try {
            String deviceName = new GetAppProperty().execute("NAME_DEVICE_SCANNER");
            scanner.open(deviceName);
            infoLogger.execute(OpenScanner.class, "Barcode Handler is connected to device " + deviceName, null);
        } catch (JposException e) {
            errorLogger.execute(OpenScanner.class, e.getMessage(), e);
        }
    }
}
