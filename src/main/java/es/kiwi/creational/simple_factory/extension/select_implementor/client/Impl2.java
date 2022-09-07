package es.kiwi.creational.simple_factory.extension.select_implementor.client;

import es.kiwi.creational.simple_factory.scenario.Api;

/**
 * 对接口的实现
 */
public class Impl2 implements Api {
    @Override
    public void test1(String s) {
        System.out.println("Now in Impl2. The input s == " + s);
    }
}
