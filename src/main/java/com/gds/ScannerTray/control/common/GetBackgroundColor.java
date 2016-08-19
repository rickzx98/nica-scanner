package com.gds.ScannerTray.control.common;

import java.awt.Color;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetBackgroundColor {
    private static Color bgColor;

    public Color execute() {
        if (bgColor == null) {
            bgColor = new Color(250, 235, 215);
        }
        return bgColor;
    }
}
