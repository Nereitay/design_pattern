package es.kiwi.creational.factory_method.mosh.matcha;

import java.util.Map;

public class Controller {

    public void render(String viewName, Map<String, Object> context) {
        ViewEngine engine = creatViewEngine();
        String html = engine.render(viewName, context);
        System.out.println(html);
    }

//    protected abstract ViewEngine createViewEngine();

    protected ViewEngine creatViewEngine() {
        return new MatchaViewEngine();
    }
}
