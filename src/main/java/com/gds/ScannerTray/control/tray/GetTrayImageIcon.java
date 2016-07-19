package com.gds.ScannerTray.control.tray;

import com.gds.ScannerTray.control.common.CreateImageIcon;
import com.gds.Common.control.GetAppProperty;

import java.awt.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class GetTrayImageIcon {
    public Image execute() {
        return new CreateImageIcon().execute(new GetAppProperty().execute("TRAY_ICON"), "Barcode scanner icon");
    }
}
