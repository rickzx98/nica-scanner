package com.gds.BarcodeScanner.control.listeners;

import com.gds.Common.control.GetInfoLogger;
import jpos.events.DataEvent;
import jpos.events.DataListener;
import org.apache.log4j.Logger;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class CreateScannerDataListener {
    private static final GetInfoLogger infoLogger = new GetInfoLogger();

    public DataListener execute() {
        return createScannerDataListener();
    }

    private DataListener createScannerDataListener() {
        return new DataListener() {
            public void dataOccurred(DataEvent dataEvent) {
                infoLogger.execute(CreateScannerDataListener.class, dataEvent, null);
            }
        };
    }


}
