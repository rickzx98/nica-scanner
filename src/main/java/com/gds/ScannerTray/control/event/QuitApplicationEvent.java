package com.gds.ScannerTray.control.event;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gds.Common.control.GetAppProperty;
import com.gds.ScannerTray.control.common.CreateYesNoConfirmDialog;
import com.gds.ScannerTray.control.lifecyle.InitOnQuit;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class QuitApplicationEvent {

    public ActionListener execute(final SystemTray tray, final TrayIcon trayIcon) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = new CreateYesNoConfirmDialog().execute(new GetAppProperty().execute("TITLE_QUIT"), new GetAppProperty().execute("MESSAGE_QUIT"), new String[]{
                        new GetAppProperty().execute("LABEL_YES"),
                        new GetAppProperty().execute("LABEL_NO")
                });
                if (result == 0) {
                    tray.remove(trayIcon);
                    new InitOnQuit().execute();
                }
            }
        };
    }
}
