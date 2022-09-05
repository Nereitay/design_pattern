package es.kiwi.creational.simple_factory.problem.common;

public class Impl implements Api {
    @Override
    public void test1(String s) {
        System.out.println("Now in Impl. The input s == " + s);
    }
}
