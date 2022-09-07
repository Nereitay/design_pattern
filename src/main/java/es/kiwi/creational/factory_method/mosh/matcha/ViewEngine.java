package es.kiwi.creational.factory_method.mosh.matcha;

import java.util.Map;

public interface ViewEngine {
    String render(String viewName, Map<String, Object> context);
}
