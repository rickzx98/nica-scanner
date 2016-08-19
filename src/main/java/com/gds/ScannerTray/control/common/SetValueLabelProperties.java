package com.gds.ScannerTray.control.common;

import javax.swing.JLabel;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class SetValueLabelProperties {

    public JLabel execute(JLabel label) {
        label.setText("<html><u>" + label.getText() + "</u></html>");
        return label;
    }
}
