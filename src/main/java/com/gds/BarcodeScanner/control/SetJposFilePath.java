package com.gds.BarcodeScanner.control;

import jpos.util.JposPropertiesConst;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class SetJposFilePath {
    public void execute() {
        System.setProperty(JposPropertiesConst.JPOS_POPULATOR_FILE_PROP_NAME, System.getenv("JPOS_XML_FILE"));
    }
}
