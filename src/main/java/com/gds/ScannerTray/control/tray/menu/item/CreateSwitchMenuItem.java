package com.gds.ScannerTray.control.tray.menu.item;

import java.awt.MenuItem;

import com.gds.ScannerTray.control.common.GetStoredComponent;
import com.gds.ScannerTray.control.event.SwitchEvent;

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
