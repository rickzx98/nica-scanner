package com.gds.BarcodeScanner.control;

import com.gds.Common.control.GetAppProperty;
import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;
import com.gds.ScannerTray.control.common.GetStoredComponent;
import com.sun.glass.ui.Menu;
import jpos.JposException;
import jpos.Scanner;

import java.awt.*;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class EnableScanner {
    private final GetInfoLogger infoLogger = new GetInfoLogger();
    private final GetErrorLogger errorLogger = new GetErrorLogger();

    public void execute(Scanner scanner) {
        try {
            scanner.setDeviceEnabled(Boolean.TRUE);
            scanner.setDataEventEnabled(Boolean.TRUE);
            scanner.setDecodeData(Boolean.TRUE);
            new GetStoredComponent().execute("SWITCH_MENU", new MenuItem()).setLabel(new GetAppProperty().execute("LABEL_DISABLE"));
            infoLogger.execute(EnableScanner.class, "Scanner enabled", null);
        } catch (JposException e) {
            errorLogger.execute(EnableScanner.class, e.getMessage(), e);
        }
    }
}
