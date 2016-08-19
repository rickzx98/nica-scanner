package com.gds.ScannerTray.control.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickzx98 on 21/07/2016.
 */
public class GetStoredComponent {
    private static final Map<String, Object> COMPONENT_MAP = new HashMap<String, Object>();

    public <T> T execute(String id, T component) {
        return (T) createStoredComponent(id, component);
    }

    private Object createStoredComponent(String id, Object component) {
        Object component1 = component;
        if (COMPONENT_MAP.containsKey(id)) {
            component1 = COMPONENT_MAP.get(id);
        } else {
            COMPONENT_MAP.put(id, component);
        }
        return component1;
    }
}
