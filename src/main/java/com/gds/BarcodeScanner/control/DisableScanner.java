package com.gds.BarcodeScanner.control;

import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;
import jpos.JposException;
import jpos.Scanner;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class DisableScanner {
    private final GetInfoLogger infoLogger = new GetInfoLogger();
    private final GetErrorLogger errorLogger = new GetErrorLogger();

    public void execute(Scanner scanner) {
        try {
            scanner.setDeviceEnabled(Boolean.FALSE);
            scanner.setDataEventEnabled(Boolean.FALSE);
            infoLogger.execute(EnableScanner.class, "Scanner has been disabled", null);
        } catch (JposException e) {
            errorLogger.execute(EnableScanner.class, e.getMessage(), e);
        }
    }
}
