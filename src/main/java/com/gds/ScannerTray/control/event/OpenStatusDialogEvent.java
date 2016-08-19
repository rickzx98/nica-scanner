package com.gds.ScannerTray.control.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gds.ScannerTray.control.status.GetStatusDialog;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class OpenStatusDialogEvent {

    public ActionListener execute() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GetStatusDialog().execute();
            }
        };
    }
}
