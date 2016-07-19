package com.gds.BarcodeScanner.control;

import com.gds.Common.control.GetAppProperty;
import jpos.config.JposEntry;
import jpos.config.simple.SimpleEntryRegistry;
import jpos.config.simple.xml.SimpleXmlRegPopulator;

/**
 * Created by rickzx98 on 20/07/2016.
 */
public class InitDllLibraries {

    public void execute() {
        SimpleEntryRegistry simpleEntryRegistry = new SimpleEntryRegistry(new SimpleXmlRegPopulator());
        simpleEntryRegistry.load();
        System.loadLibrary(System.getenv("SCANNER_DLL_64"));
    }

}
