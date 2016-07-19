package control.ui.common;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateConfirmDialog {
    private String message;

    public JDialog execute(String message) {
        this.message = message;
        return createDialog();
    }

    private JDialog createDialog() {
        JDialog dialog = new JDialog(null, "Confirm dialog", Dialog.ModalityType.MODELESS);
        dialog.setContentPane(createPanel());
        dialog.setAlwaysOnTop(Boolean.TRUE);
        dialog.setModal(Boolean.TRUE);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        return dialog;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(getConfirmMessageLabel(), c);
        return panel;
    }

    private JLabel getConfirmMessageLabel() {
        return new CreateLabel().execute(message);
    }
}
