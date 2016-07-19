package com.gds.ScannerTray.control.common;

import javax.swing.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateLabel {
    public JLabel execute(String label) {
        return createLabel(label);
    }

    private JLabel createLabel(String label) {
        JLabel labell = new JLabel(label);
        return labell;
    }
}
