package es.kiwi.creational.factory_method.mosh.sharp;

import es.kiwi.creational.factory_method.mosh.matcha.ViewEngine;

import java.util.Map;

public class SharpNewEngine implements ViewEngine {
    @Override
    public String render(String viewName, Map<String, Object> context) {
        return "View render by sharp";
    }
}
