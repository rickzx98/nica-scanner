package com.gds.ScannerTray.control.common;

import javax.swing.JOptionPane;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateYesNoConfirmDialog {

    public int execute(String title, String message, String[] options) {
        return createDialog(title, message, options);
    }

    private int createDialog(String title, String message, String[] options) {
        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
    }
}
