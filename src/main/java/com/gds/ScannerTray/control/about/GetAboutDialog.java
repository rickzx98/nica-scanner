package com.gds.ScannerTray.control.about;

import java.awt.Container;

import javax.swing.JDialog;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.common.CreateJDialog;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetAboutDialog {
    private final CreateJDialog createJDialog = new CreateJDialog();
    private static JDialog dialog;

    public void execute() {
        if (dialog == null) {
            Container aboutContent = new CreateAboutContent().execute();
            dialog = createJDialog.execute(new GetAppProperty().execute("TITLE_DIALOG_ABOUT"), null, aboutContent);
            dialog.setSize(620, 180);
        }
        if (!dialog.isVisible()) {
            dialog.setVisible(Boolean.TRUE);
        }
    }
}
