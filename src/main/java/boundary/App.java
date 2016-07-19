package boundary;

import control.ui.CreateAppUI;
import control.ui.SetUILookAndFeel;

import javax.swing.*;

public class App {

    private static final CreateAppUI createAppUI = new CreateAppUI();

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
                createAppUI.execute();
            }
        });
    }
}
