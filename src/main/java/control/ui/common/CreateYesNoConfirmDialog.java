package control.ui.common;

import control.ui.tray.GetTrayImageIcon;

import javax.swing.*;
import java.awt.*;

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
