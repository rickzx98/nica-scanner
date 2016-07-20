package com.gds.ScannerTray.control.tray.menu.item;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.event.QuitApplicationEvent;

import java.awt.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateExitMenuItem {
    private SystemTray systemTray;
    private TrayIcon trayIcon;

    public MenuItem execute(SystemTray systemTray, TrayIcon trayIcon) {
        this.systemTray = systemTray;
        this.trayIcon = trayIcon;
        return createMenuItem();
    }

    private MenuItem createMenuItem() {
        MenuItem menuItem = new MenuItem();
        menuItem.setLabel(new GetAppProperty().execute("LABEL_EXIT"));
        menuItem.addActionListener(new QuitApplicationEvent().execute(systemTray, trayIcon));
        return menuItem;
    }
}
