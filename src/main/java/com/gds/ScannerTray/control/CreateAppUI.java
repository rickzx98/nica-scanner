package com.gds.ScannerTray.control;

import com.gds.ScannerTray.control.tray.InitSystemTray;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateAppUI {

    public boolean execute() {
        return new InitSystemTray().execute();
    }

}
