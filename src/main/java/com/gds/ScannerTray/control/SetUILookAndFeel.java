package com.gds.ScannerTray.control;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SetUILookAndFeel {
    public void execute() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
    }
}
