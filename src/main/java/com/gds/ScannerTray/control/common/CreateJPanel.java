package com.gds.ScannerTray.control.common;

import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class CreateJPanel {

    public JPanel execute(LayoutManager layout) {
        return createJPanelInstance(layout);
    }

    private JPanel createJPanelInstance(LayoutManager layout) {
        JPanel panel = new JPanel();
        panel.setBackground(new GetBackgroundColor().execute());
        if (layout != null) {
            panel.setLayout(layout);
        }
        return panel;
    }
}
