package control.ui.tray.menu;

import control.ui.tray.menu.item.CreateExitMenuItem;
import control.ui.tray.menu.item.CreateScannerStatusMenuItem;

import java.awt.*;

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
        popupMenu.add(new CreateScannerStatusMenuItem().execute());
        popupMenu.addSeparator();
        popupMenu.add(new CreateExitMenuItem().execute(systemTray, trayIcon));
        return popupMenu;
    }

}
