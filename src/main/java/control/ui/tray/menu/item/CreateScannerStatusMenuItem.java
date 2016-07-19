package control.ui.tray.menu.item;

import control.ui.common.GetAppProperty;
import control.ui.event.OpenStatusDialogEvent;

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
