package com.gds.ScannerLogger.control;

import com.gds.Common.control.GetErrorLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class WriteScannedData {
    private GetErrorLogger errorLogger = new GetErrorLogger();

    public void execute(Long when, String data, String deviceName, String type) {
        FileWriter fileWriter = createFileWriterInstance();
        try {
            fileWriter.append(createLogLine(when, data, deviceName, type));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            errorLogger.execute(WriteScannedData.class, e.getMessage(), e);
        }
    }

    private String createLogLine(Long when, String data, String deviceName, String type) {
        return new StringBuilder('\n').append(when).append(",").append(data).append(",").append(deviceName).append(",").append(type).append("\n").toString();
    }

    private FileWriter createFileWriterInstance() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new GetLogFile().execute().getAbsolutePath(), Boolean.TRUE);
        } catch (IOException e) {
            errorLogger.execute(WriteScannedData.class, e.getMessage(), e);
        }
        return fileWriter;
    }


}
