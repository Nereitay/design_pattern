package es.kiwi.Creational.simple_factory.problem.refactor;

import es.kiwi.Creational.simple_factory.problem.common.Api;
import es.kiwi.Creational.simple_factory.problem.common.Impl;
/**
 * 工厂类，用来创建api对象
 */
public class Factory {

    public static Api createApi() {
        return new Impl();
    }
}
