package com.gds.ScannerTray.control.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gds.BarcodeScanner.control.ClaimScanner;
import com.gds.BarcodeScanner.control.DisableScanner;
import com.gds.BarcodeScanner.control.EnableScanner;
import com.gds.BarcodeScanner.control.GetScannerInstance;
import com.gds.BarcodeScanner.control.ReleaseScanner;
import com.gds.Common.control.GetErrorLogger;

import jpos.JposException;
import jpos.Scanner;

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
