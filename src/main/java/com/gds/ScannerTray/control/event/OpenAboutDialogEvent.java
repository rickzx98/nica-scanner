package com.gds.ScannerTray.control.event;

import com.gds.ScannerTray.control.about.GetAboutDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class OpenAboutDialogEvent {

    public ActionListener execute() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GetAboutDialog().execute();
            }
        };
    }
}
