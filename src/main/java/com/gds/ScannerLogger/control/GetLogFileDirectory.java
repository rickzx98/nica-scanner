package com.gds.ScannerLogger.control;

import java.io.File;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetLogFileDirectory {

    private static File directory;

    public File execute() {
        if (directory == null) {
            directory = new File(System.getenv("GDS_BS_LOG_PATH"));
            if (!directory.exists()) {
                directory.mkdirs();
            }
        }
        return directory;
    }

}
