package com.gds.ScannerTray.control.lifecyle;

import com.gds.BarcodeScanner.boundary.BarcodeScanner;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class InitOnQuit {

    public void execute() {
        createOnQuitThread().start();
    }

    private Thread createOnQuitThread() {
        Thread thread = new Thread(new OnQuit());
        thread.setName("ScanOptQuitCycle");
        return thread;
    }

    private class OnQuit implements Runnable {
        public void run() {
            new BarcodeScanner().stop();
            System.exit(0);
        }
    }

}
