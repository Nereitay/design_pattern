package es.kiwi.creational.simple_factory.solution;

import es.kiwi.creational.simple_factory.scenario.Api;
import es.kiwi.creational.simple_factory.scenario.Impl;
/**
 * 工厂类，用来创建api对象
 */
public class Factory {

    /**
     * 具体创建Api对象的方法
     * @return 创建好的Api对象
     */
    public static Api createApi() {
        //由于只有一个实现，就不用条件来判断了
        return new Impl();
    }
}
