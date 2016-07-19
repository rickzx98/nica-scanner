package com.gds.Common.control;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by rickzx98 on 19/07/2016.
 */
public class GetAppProperty {

    private static Properties PROPERTIES;

    private static void createProperties() {
        if (PROPERTIES == null) {
            PROPERTIES = new Properties();
            try {
                PROPERTIES.load(GetAppProperty.class.getClassLoader().getResourceAsStream("app.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String execute(String key) {
        createProperties();
        return getPropertyValue(key);
    }

    private String getPropertyValue(String key) {
        String value = "";
        if (PROPERTIES.containsKey(key)) {
            value = PROPERTIES.getProperty(key);
        }
        return value;
    }
}
