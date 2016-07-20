package com.gds.ScannerTray.control.common;

import com.gds.Common.control.GetAppProperty;
import com.gds.Common.control.GetErrorLogger;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetGDSIcon {
    private final GetErrorLogger errorLogger = new GetErrorLogger();

    public ImageIcon execute() {
        ImageIcon icon = null;
        Image image = null;
        try {
            image = new CreateImageIcon().execute(new GetAppProperty().execute("ICON_GDS"), new GetAppProperty().execute("LABEL_COMPANY_ICON")).getScaledInstance(128, 128, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            errorLogger.execute(GetTrayIconPNG.class, e.getMessage(), e);
        }
        if (image != null) {
            icon = new ImageIcon(image);
        }
        return icon;
    }
}
