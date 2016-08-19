package com.gds.ScannerTray.control.status;

import java.awt.Container;

import javax.swing.JDialog;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.common.CreateJDialog;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class GetStatusDialog {
    private final CreateJDialog createJDialog = new CreateJDialog();
    private static JDialog dialog;

    public void execute() {
        if (dialog == null) {
            Container statusContent = new CreateStatusContent().execute();
            dialog = createJDialog.execute(new GetAppProperty().execute("TITLE_DIALOG_STATUS"), null, statusContent);
            dialog.setSize(500, 180);
        }
        if (!dialog.isVisible()) {
            dialog.setVisible(Boolean.TRUE);
        }
    }
}
