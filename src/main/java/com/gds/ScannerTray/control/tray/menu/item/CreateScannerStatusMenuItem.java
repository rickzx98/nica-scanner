package com.gds.ScannerTray.control.tray.menu.item;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.event.OpenStatusDialogEvent;

import java.awt.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateScannerStatusMenuItem {
    public MenuItem execute() {
        return createMenuItem();
    }

    private MenuItem createMenuItem() {
        MenuItem menuItem = new MenuItem();
        menuItem.setLabel(new GetAppProperty().execute("LABEL_STATUS"));
        menuItem.addActionListener(new OpenStatusDialogEvent());
        return menuItem;
    }
}
