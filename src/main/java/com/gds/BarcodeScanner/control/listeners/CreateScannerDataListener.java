package com.gds.BarcodeScanner.control.listeners;

import com.gds.BarcodeScanner.control.EnableScanner;
import com.gds.BarcodeScanner.control.GetBarcodeScannerTypeName;
import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;
import com.gds.ScannerLogger.boundary.ScannerLogger;
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
    private ScannerLogger scannerLogger = new ScannerLogger();

    public DataListener execute() {
        return createScannerDataListener();
    }

    private DataListener createScannerDataListener() {
        return new DataListener() {
            public void dataOccurred(DataEvent dataEvent) {
                Scanner scanner = (Scanner) dataEvent.getSource();
                new EnableScanner().execute(scanner);
                infoLogger.execute(CreateScannerDataListener.class, "Status: " + dataEvent.getStatus(), null);
                try {
                    infoLogger.execute(CreateScannerDataListener.class, "data: " + new String(scanner.getScanData()), null);
                    scannerLogger.log(dataEvent.getWhen(), new String(scanner.getScanData()), scanner.getPhysicalDeviceName(), new GetBarcodeScannerTypeName().execute(scanner.getScanDataType()));
                } catch (JposException e) {
                    errorLogger.execute(CreateScannerDataListener.class, e.getMessage(), e);
                }
                infoLogger.execute(CreateScannerDataListener.class, "Sequence: " + dataEvent.getSequenceNumber(), null);
                infoLogger.execute(CreateScannerDataListener.class, dataEvent, null);
            }
        };
    }


}
