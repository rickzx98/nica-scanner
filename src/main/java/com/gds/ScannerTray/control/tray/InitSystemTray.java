package com.gds.ScannerTray.control.tray;

import java.awt.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class InitSystemTray {
    private static SystemTray systemTray;

    public boolean execute() {
        boolean create = systemTray == null;
        if (create) {
            systemTray = createSystemTray();
            if (systemTray != null) {
                addSystemTrayIcon(systemTray);
            }
        }
        return create;
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
