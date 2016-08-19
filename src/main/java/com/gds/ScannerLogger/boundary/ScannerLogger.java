package com.gds.ScannerLogger.boundary;

import com.gds.ScannerLogger.control.WriteScannedData;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class ScannerLogger {
    public void log(long when, String data, String device, String type) {
        new WriteScannedData().execute(when, data, device, type);
    }
}
