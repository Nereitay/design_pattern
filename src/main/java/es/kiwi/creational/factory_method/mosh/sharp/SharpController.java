package es.kiwi.creational.factory_method.mosh.sharp;

import es.kiwi.creational.factory_method.mosh.matcha.Controller;
import es.kiwi.creational.factory_method.mosh.matcha.ViewEngine;

public class SharpController extends Controller {

    @Override
    protected ViewEngine creatViewEngine() {
        return new SharpNewEngine();
    }
}
