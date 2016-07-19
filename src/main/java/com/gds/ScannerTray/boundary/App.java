package com.gds.ScannerTray.boundary;

import com.gds.BarcodeScanner.boundary.BarcodeScanner;
import com.gds.ScannerTray.control.CreateAppUI;
import com.gds.ScannerTray.control.SetUILookAndFeel;

import javax.swing.*;

public class App {

    private static final CreateAppUI createAppUI = new CreateAppUI();
    private static final BarcodeScanner barcodeScanner = new BarcodeScanner();

    public static void main(String... args) {
        /* Use an appropriate Look and Feel */
        try {
            new SetUILookAndFeel().execute();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                barcodeScanner.start();
                createAppUI.execute();
            }
        });
    }
}
