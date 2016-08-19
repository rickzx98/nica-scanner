package com.gds.ScannerLogger.control;

import java.io.File;
import java.io.IOException;

import com.gds.Common.control.GetErrorLogger;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetLogFile {
    private GetErrorLogger errorLogger = new GetErrorLogger();

    public File execute() {
        return createFileInstance();
    }

    private File createFileInstance() {
        File file = new File(new GetLogFileDirectory().execute(), new GetFileName().execute());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                errorLogger.execute(GetLogFile.class, e.getMessage(), e);
            }
        }
        return file;
    }
}
