package com.gds.BarcodeScanner.control;

import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;

import jpos.JposException;
import jpos.Scanner;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class ReleaseScanner {
    private final GetErrorLogger errorLogger = new GetErrorLogger();
    private final GetInfoLogger infoLogger = new GetInfoLogger();

    public void execute(Scanner scanner) {
        try {
            scanner.release();
            infoLogger.execute(ClaimScanner.class, "Scanner has been released", null);
        } catch (JposException e) {
            errorLogger.execute(ClaimScanner.class, e.getMessage(), e);
        }
    }
}
