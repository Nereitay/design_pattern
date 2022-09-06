package es.kiwi.creational.singleton.mosh;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager1 {

    private Map<String, Object> settings = new HashMap<>();

    private static ConfigManager1 instance = new ConfigManager1();

    private ConfigManager1() {
    }

    public static ConfigManager1 getInstance() {
        return instance;
    }

    public void set(String key, Object value) {
        settings.put(key, value);
    }

    public Object get(String key) {
        return settings.get(key);
    }
}
