package com.gds.ScannerTray.control.event;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gds.BarcodeScanner.control.DisableScanner;
import com.gds.BarcodeScanner.control.EnableScanner;
import com.gds.BarcodeScanner.control.GetScannerInstance;
import com.gds.Common.control.GetAppProperty;
import com.gds.Common.control.GetErrorLogger;

import jpos.JposException;
import jpos.Scanner;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class SwitchEvent {
    private GetErrorLogger errorLogger = new GetErrorLogger();

    public ActionListener execute() {
        return createActionListenerInstance();
    }

    private ActionListener createActionListenerInstance() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchScanner(e);
            }
        };
    }

    private void switchScanner(ActionEvent evt) {
        Scanner scanner = new GetScannerInstance().execute();
        MenuItem switchItem = (MenuItem) evt.getSource();
        try {
            if (scanner.getDeviceEnabled()) {
                switchItem.setLabel(new GetAppProperty().execute("LABEL_DISABLE"));
                new DisableScanner().execute(scanner);
            } else {
                switchItem.setLabel(new GetAppProperty().execute("LABEL_ENABLE"));
                new EnableScanner().execute(scanner);
            }
        } catch (JposException e) {
            errorLogger.execute(SwitchEvent.class, e.getMessage(), e);
        }
    }
}
