package com.gds.BarcodeScanner.control.listeners;

import jpos.events.DirectIOEvent;
import jpos.events.DirectIOListener;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateScannerDirectIOListener {

    public DirectIOListener execute() {
        return createDirectIOListenerInstance();
    }

    private DirectIOListener createDirectIOListenerInstance() {
        return new DirectIOListener() {
            @Override
            public void directIOOccurred(DirectIOEvent directIOEvent) {
            }
        };
    }

}
