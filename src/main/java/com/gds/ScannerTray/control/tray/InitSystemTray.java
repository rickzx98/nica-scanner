package com.gds.ScannerTray.control.tray;

import java.awt.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class InitSystemTray {

    public void execute() {
        SystemTray systemTray = createSystemTray();
        if (systemTray != null) {
            addSystemTrayIcon(systemTray);
        }
    }

    private SystemTray createSystemTray() {
        SystemTray tray = null;
        if (SystemTray.isSupported()) {
            tray = SystemTray.getSystemTray();
        }
        return tray;
    }

    private void addSystemTrayIcon(SystemTray systemTray) {
        try {
            systemTray.add(new CreateTrayIcon().execute(systemTray));
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
