package com.gds.ScannerTray.control.common;

import com.gds.ScannerTray.boundary.App;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateImageIcon {
    public Image execute(String path, String description) {
        return createImageIcon(path, description);
    }

    private Image createImageIcon(String path, String description) {
        URL imageURL = App.class.getClassLoader().getResource("icon/" + path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
