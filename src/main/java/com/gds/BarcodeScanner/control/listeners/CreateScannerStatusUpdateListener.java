package com.gds.BarcodeScanner.control.listeners;

import com.gds.BarcodeScanner.control.ClaimScanner;
import com.gds.BarcodeScanner.control.EnableScanner;
import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;

import jpos.JposException;
import jpos.Scanner;
import jpos.events.StatusUpdateEvent;
import jpos.events.StatusUpdateListener;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateScannerStatusUpdateListener {

    private final GetInfoLogger infoLogger = new GetInfoLogger();
    private final GetErrorLogger errorLogger = new GetErrorLogger();

    public StatusUpdateListener execute() {
        return createStatusUpdateListenerInstance();
    }

    private StatusUpdateListener createStatusUpdateListenerInstance() {
        return new StatusUpdateListener() {
            @Override
            public void statusUpdateOccurred(StatusUpdateEvent statusUpdateEvent) {
                connectScannerIfFound(statusUpdateEvent.getSource());
            }
        };
    }


    private void connectScannerIfFound(Object source) {
        Scanner scanner = null;
        try {
            scanner = getScanner(source);
        } catch (JposException e) {
            errorLogger.execute(CreateScannerDirectIOListener.class, e.getMessage(), e);
        }
        if (scanner != null) {
            new ClaimScanner().execute(scanner);
            new EnableScanner().execute(scanner);
        }
    }

    private Scanner getScanner(Object source) throws JposException {
        Scanner scanner = null;
        if (source != null && source instanceof Scanner) {
            infoLogger.execute(CreateScannerDirectIOListener.class, "Found device " + scanner.getPhysicalDeviceName(), null);
            scanner = (Scanner) source;
        }
        return scanner;
    }


}
