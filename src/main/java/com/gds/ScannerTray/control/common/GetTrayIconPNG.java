package com.gds.ScannerTray.control.common;

import com.gds.Common.control.GetAppProperty;
import com.gds.Common.control.GetErrorLogger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetTrayIconPNG {
    private final GetErrorLogger errorLogger = new GetErrorLogger();

    public ImageIcon execute() {
        ImageIcon icon = null;
        Image image = null;
        try {
            image = new CreateImageIcon().execute(new GetAppProperty().execute("ICON_TRAY_128"), new GetAppProperty().execute("LABEL_SYSTEM_ICON"));
        } catch (Exception e) {
            errorLogger.execute(GetTrayIconPNG.class, e.getMessage(), e);
        }
        if (image != null) {
            icon = new ImageIcon(image);
        }
        return icon;
    }
}
