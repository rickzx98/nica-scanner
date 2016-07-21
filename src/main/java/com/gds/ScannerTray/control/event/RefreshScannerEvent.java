package com.gds.ScannerTray.control.event;

import com.gds.BarcodeScanner.control.*;
import com.gds.Common.control.GetErrorLogger;
import jpos.JposException;
import jpos.Scanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class RefreshScannerEvent {
    private GetErrorLogger errorLogger = new GetErrorLogger();

    public ActionListener execute() {
        return createActionListenerInstance();
    }

    private ActionListener createActionListenerInstance() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshScanner();
            }
        };
    }

    private void refreshScanner() {
        Scanner scanner = new GetScannerInstance().execute();
        try {
            if (!scanner.getDeviceEnabled()) {
                new ClaimScanner().execute(scanner);
                new EnableScanner().execute(scanner);
            } else {
                new ReleaseScanner().execute(scanner);
                new DisableScanner().execute(scanner);
                new ClaimScanner().execute(scanner);
                new EnableScanner().execute(scanner);
            }
        } catch (JposException e) {
            errorLogger.execute(RefreshScannerEvent.class, e.getMessage(), e);
        }
    }
}
