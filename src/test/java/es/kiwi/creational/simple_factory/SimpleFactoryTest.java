package es.kiwi.creational.simple_factory;

import es.kiwi.creational.simple_factory.scenario.Api;
import es.kiwi.creational.simple_factory.scenario.Impl;
import es.kiwi.creational.simple_factory.solution.sample.Factory;
import org.junit.Test;

public class SimpleFactoryTest {

    @Test
    public void scenario() {
        /*
        客户端调用时不仅知道接口同时还知道了具体实现，
        不符合接口的思想：“封装隔离”
         */
        Api api = new Impl();
        api.test1("Just a test! No need to be nervous :)");
    }

    /**
     * 简单工厂示例代码
     */
    @Test
    public void sample() {
        //通过简单工厂来获取接口对象
        es.kiwi.creational.simple_factory.solution.sample.Api api = Factory.createApi(1);
        api.operation("Simple Factory dp");
    }

    /**
     * 使用简单工厂重写示例
     * <p>
     * 简单工厂能帮助我们真正地面向接口编程
     */
    @Test
    public void simpleFactory() {
        //重要改变，没有new Impl()了，取而代之Factory.createApi()
        Api api = es.kiwi.creational.simple_factory.solution.Factory.createApi();
        api.test1("Just a test! No need to be nervous :)");
    }

    /**
     * 由客户端在调用工厂的时候传入选择的参数
     */
    @Test
    public void parameter() {
        //注意这里传递的参数，修改参数就可以修改行为，试试看吧
        Api api = es.kiwi.creational.simple_factory.extension.select_implementor.client.Factory.createApi(2);
        api.test1("Just a test! No need to be nervous :)");

    }

    /**
     * 使用反射家伙是那个配置文件，来实现添加新的实现类后，
     * 无须修改代码，就能把这个实现类加入应用中
     */
    @Test
    public void configurable() {
        es.kiwi.creational.simple_factory.solution.sample.Api api =
                es.kiwi.creational.simple_factory.extension.select_implementor.configurable.Factory.createApi();
        api.operation("简单工厂使用配置文件创建");
    }
}
