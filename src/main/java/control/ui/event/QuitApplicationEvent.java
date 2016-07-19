package control.ui.event;

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
        tray.remove(trayIcon);
        System.exit(0);
    }
}
