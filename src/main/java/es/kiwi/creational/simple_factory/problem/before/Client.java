package es.kiwi.creational.simple_factory.problem.before;

import es.kiwi.creational.simple_factory.problem.common.Api;
import es.kiwi.creational.simple_factory.problem.common.Impl;

public class Client {
    public static void main(String[] args) {
        /*
        客户端调用时不仅知道接口同时还知道了具体实现，不符合接口的思想：“封装隔离”
         */
        Api api = new Impl();
        api.test1("It's just a test....");
    }
}
