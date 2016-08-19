package com.gds.ScannerTray.control.common;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateLabel {
    public JLabel execute(String label) {
        return createLabel(label);
    }

    private JLabel createLabel(String label) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        return jLabel;
    }
}
