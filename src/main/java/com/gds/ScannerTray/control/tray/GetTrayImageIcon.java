package com.gds.ScannerTray.control.tray;

import java.awt.Image;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.common.CreateImageIcon;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class GetTrayImageIcon {
    public Image execute() {
        return new CreateImageIcon().execute(new GetAppProperty().execute("TRAY_ICON"), "Barcode scanner icon");
    }
}
