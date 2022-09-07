package es.kiwi.creational.simple_factory.scenario;

/**
 * 对接口的实现
 */
public class Impl implements Api {
    @Override
    public void test1(String s) {
        System.out.println("Now in Impl. The input s == " + s);
    }
}
