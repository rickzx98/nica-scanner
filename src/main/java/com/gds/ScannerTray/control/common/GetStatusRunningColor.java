package com.gds.ScannerTray.control.common;

import java.awt.*;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetStatusRunningColor {
    private static Color color;

    public Color execute() {
        if (color == null) {
            color = new Color(46, 201, 57);
        }
        return color;
    }
}
