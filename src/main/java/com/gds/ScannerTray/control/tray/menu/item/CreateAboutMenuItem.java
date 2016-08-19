package com.gds.ScannerTray.control.tray.menu.item;

import java.awt.MenuItem;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.event.OpenAboutDialogEvent;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateAboutMenuItem {

    public MenuItem execute() {
        return createMenuItem();
    }

    private MenuItem createMenuItem() {
        MenuItem menuItem = new MenuItem();
        menuItem.setLabel(new GetAppProperty().execute("LABEL_ABOUT"));
        menuItem.addActionListener(new OpenAboutDialogEvent().execute());
        return menuItem;
    }
}
