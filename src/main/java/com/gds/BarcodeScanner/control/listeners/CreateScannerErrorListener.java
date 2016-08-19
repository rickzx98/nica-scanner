package com.gds.BarcodeScanner.control.listeners;

import com.gds.Common.control.GetErrorLogger;

import jpos.events.ErrorEvent;
import jpos.events.ErrorListener;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateScannerErrorListener {
    private final GetErrorLogger errorLogger = new GetErrorLogger();

    public ErrorListener execute() {
        return createErrorListenerInstance();
    }

    private ErrorListener createErrorListenerInstance() {
        return new ErrorListener() {
            @Override
            public void errorOccurred(ErrorEvent errorEvent) {
                String errorLog = "SCANNER_ERROR=".concat("CODE:").concat(String.valueOf(errorEvent.getErrorCode())).concat("|")
                        .concat("WHEN:").concat(String.valueOf(errorEvent.getWhen())).concat("|")
                        .concat("RESPONSE").concat(String.valueOf(errorEvent.getErrorResponse()));
                errorLogger.execute(CreateScannerDataListener.class, errorLog, null);
            }
        };
    }
}
