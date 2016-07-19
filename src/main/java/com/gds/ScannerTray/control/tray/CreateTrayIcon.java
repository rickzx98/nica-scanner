package com.gds.ScannerTray.control.tray;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.tray.menu.CreateTrayMenu;

import java.awt.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateTrayIcon {
    public TrayIcon execute(SystemTray systemTray) {
        return createTrayIcon(systemTray);
    }

    private TrayIcon createTrayIcon(SystemTray systemTray) {
        TrayIcon trayIcon = new TrayIcon(new GetTrayImageIcon().execute());
        trayIcon.setImageAutoSize(Boolean.TRUE);
        trayIcon.setToolTip(new GetAppProperty().execute("LABEL_TRAY_TOOLTIP"));
        trayIcon.setPopupMenu(new CreateTrayMenu().execute(systemTray, trayIcon));
        return trayIcon;
    }

}
