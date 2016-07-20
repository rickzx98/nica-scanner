package com.gds.ScannerTray.control.common;

import com.gds.ScannerTray.control.properties.GetDialogDefaultDimension;
import com.gds.ScannerTray.control.tray.GetTrayImageIcon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class CreateJDialog {
    public JDialog execute(String title, Component parent, Container content) {
        return createJDialogInstance(title, parent, content);
    }

    private JDialog createJDialogInstance(String title, Component parent, Container content) {
        JDialog jDialog = new JDialog();
        jDialog.setTitle(title);
        jDialog.setSize(new GetDialogDefaultDimension().execute());
        jDialog.setIconImage(new GetTrayImageIcon().execute());
        jDialog.setContentPane(content);
        jDialog.setLocationRelativeTo(parent);
        return jDialog;
    }
}
