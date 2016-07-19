package control.ui.event;

import control.ui.common.CreateYesNoConfirmDialog;
import control.ui.common.GetAppProperty;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class QuitApplicationEvent implements ActionListener {
    private SystemTray tray;
    private TrayIcon trayIcon;

    private QuitApplicationEvent() {
        super();
    }

    public QuitApplicationEvent(SystemTray tray, TrayIcon trayIcon) {
        this();
        this.tray = tray;
        this.trayIcon = trayIcon;
    }

    public void actionPerformed(ActionEvent e) {
        int result = new CreateYesNoConfirmDialog().execute(new GetAppProperty().execute("TITLE_QUIT"), new GetAppProperty().execute("MESSAGE_QUIT"), new String[]{
                new GetAppProperty().execute("LABEL_YES"),
                new GetAppProperty().execute("LABEL_NO")
        });
        if (result == 0) {
            tray.remove(trayIcon);
        }
    }
}
