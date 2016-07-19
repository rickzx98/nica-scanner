package control.ui;

import control.ui.tray.InitSystemTray;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class CreateAppUI {

    public void execute() {
        new InitSystemTray().execute();
    }

}
