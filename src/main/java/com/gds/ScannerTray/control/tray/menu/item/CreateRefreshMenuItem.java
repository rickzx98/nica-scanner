package com.gds.ScannerTray.control.tray.menu.item;

import java.awt.MenuItem;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.event.RefreshScannerEvent;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateRefreshMenuItem {

    public MenuItem execute() {
        return createMenuItem();
    }

    private MenuItem createMenuItem() {
        MenuItem menuItem = new MenuItem();
        menuItem.setLabel(new GetAppProperty().execute("LABEL_REFRESH"));
        menuItem.addActionListener(new RefreshScannerEvent().execute());
        return menuItem;
    }
}
