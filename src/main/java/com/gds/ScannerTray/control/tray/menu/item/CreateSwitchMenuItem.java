package com.gds.ScannerTray.control.tray.menu.item;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.common.GetStoredComponent;
import com.gds.ScannerTray.control.event.OpenAboutDialogEvent;
import com.gds.ScannerTray.control.event.SwitchEvent;

import java.awt.*;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateSwitchMenuItem {
    public MenuItem execute() {
        return createMenuItem();
    }

    private MenuItem createMenuItem() {
        MenuItem menuItem = new GetStoredComponent().execute("SWITCH_MENU", new MenuItem());
        menuItem.addActionListener(new SwitchEvent().execute());
        return menuItem;
    }
}
