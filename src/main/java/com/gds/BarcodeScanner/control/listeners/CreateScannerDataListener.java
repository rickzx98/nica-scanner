package com.gds.BarcodeScanner.control.listeners;

import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;
import jpos.JposException;
import jpos.Scanner;
import jpos.events.DataEvent;
import jpos.events.DataListener;
import org.apache.log4j.Logger;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class CreateScannerDataListener {
    private static final GetInfoLogger infoLogger = new GetInfoLogger();
    private static final GetErrorLogger errorLogger = new GetErrorLogger();

    public DataListener execute() {
        return createScannerDataListener();
    }

    private DataListener createScannerDataListener() {
        return new DataListener() {
            public void dataOccurred(DataEvent dataEvent) {
                Scanner scanner = (Scanner) dataEvent.getSource();

                infoLogger.execute(CreateScannerDataListener.class, "Status: " + dataEvent.getStatus(), null);
                try {
                    infoLogger.execute(CreateScannerDataListener.class, "data: " + new String(scanner.getScanData()), null);
                } catch (JposException e) {
                    errorLogger.execute(CreateScannerDataListener.class, e.getMessage(), e);
                }
                infoLogger.execute(CreateScannerDataListener.class, "Sequence: " + dataEvent.getSequenceNumber(), null);
                infoLogger.execute(CreateScannerDataListener.class, dataEvent, null);
            }
        };
    }


}
