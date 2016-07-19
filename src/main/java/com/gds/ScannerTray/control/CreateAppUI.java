package com.gds.ScannerTray.control;

import com.gds.ScannerTray.control.tray.InitSystemTray;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateAppUI {

    public void execute() {
        new InitSystemTray().execute();
    }

}
