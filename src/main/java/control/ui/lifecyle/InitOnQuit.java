package control.ui.lifecyle;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class InitOnQuit {

    public void execute() {
        createOnQuitThread().start();
    }

    private Thread createOnQuitThread() {
        Thread thread = new Thread(new OnQuit());
        thread.setName("ScanOptQuitCycle");
        return thread;
    }

    private class OnQuit implements Runnable {
        public void run() {
            System.exit(0);
        }
    }

}
