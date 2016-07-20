package com.gds.ScannerTray.control.common;

import javax.swing.*;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class SetFormLabelProperties {

    public JLabel execute(JLabel label) {
        label.setText("<html><b>" + label.getText() + "</b></html>");

        return label;
    }
}
