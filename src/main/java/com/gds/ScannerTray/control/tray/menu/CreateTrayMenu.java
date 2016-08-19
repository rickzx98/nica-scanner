package com.gds.ScannerTray.control.tray.menu;

import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import com.gds.ScannerTray.control.tray.menu.item.CreateAboutMenuItem;
import com.gds.ScannerTray.control.tray.menu.item.CreateExitMenuItem;
import com.gds.ScannerTray.control.tray.menu.item.CreateRefreshMenuItem;
import com.gds.ScannerTray.control.tray.menu.item.CreateScannerStatusMenuItem;
import com.gds.ScannerTray.control.tray.menu.item.CreateSwitchMenuItem;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateTrayMenu {
    private SystemTray systemTray;
    private TrayIcon trayIcon;

    public PopupMenu execute(SystemTray systemTray, TrayIcon trayIcon) {
        this.systemTray = systemTray;
        this.trayIcon = trayIcon;
        return createPopupMenu();
    }

    private PopupMenu createPopupMenu() {
        PopupMenu popupMenu = new PopupMenu();
        popupMenu.add(new CreateSwitchMenuItem().execute());
        popupMenu.add(new CreateScannerStatusMenuItem().execute());
        popupMenu.add(new CreateRefreshMenuItem().execute());
        popupMenu.add(new CreateAboutMenuItem().execute());
        popupMenu.addSeparator();
        popupMenu.add(new CreateExitMenuItem().execute(systemTray, trayIcon));
        return popupMenu;
    }

}
