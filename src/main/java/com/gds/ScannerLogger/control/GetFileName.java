package com.gds.ScannerLogger.control;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetFileName {

    public String execute() {
        StringBuilder fileName = new StringBuilder();
        Calendar today = getTodayCalendar();
        String year = String.valueOf(today.get(Calendar.YEAR));
        String month = String.valueOf(today.get(Calendar.MONTH));
        String day = String.valueOf(today.get(Calendar.DAY_OF_MONTH));
        fileName.append("_").append(year).append("_")
                .append(month).append("_")
                .append(day).append(".log");
        return fileName.toString();
    }

    private Calendar getTodayCalendar() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        return calendar;
    }
}
