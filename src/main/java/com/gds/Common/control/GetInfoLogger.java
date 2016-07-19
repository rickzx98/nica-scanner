package com.gds.Common.control;

import org.apache.log4j.Logger;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class GetInfoLogger {
    private Logger logger;

    public void execute(Class clazz, Object log, Throwable throwable) {
        if (logger == null) {
            logger = createLoggerInstance(clazz);
        }
        if (logger.isInfoEnabled()) {
            logger.info(log, throwable);
        }
    }

    private Logger createLoggerInstance(Class clazz) {
        return Logger.getLogger(clazz);
    }
}
