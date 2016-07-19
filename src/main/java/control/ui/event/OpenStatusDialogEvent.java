package control.ui.event;

import control.ui.common.CreateConfirmDialog;
import control.ui.common.GetAppProperty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class OpenStatusDialogEvent implements ActionListener {
    JDialog jDialog = new CreateConfirmDialog().execute(new GetAppProperty().execute("LABEL_CONFIRM_MESSAGE"));

    @Override
    public void actionPerformed(ActionEvent e) {
        jDialog.setVisible(Boolean.TRUE);
    }
}
