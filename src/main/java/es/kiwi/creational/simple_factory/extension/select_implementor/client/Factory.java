package es.kiwi.creational.simple_factory.extension.select_implementor.client;

import es.kiwi.creational.simple_factory.scenario.Api;
import es.kiwi.creational.simple_factory.scenario.Impl;

/**
 * 工厂类，用来创建api对象
 */
public class Factory {

    /**
     * 具体创建Api对象的方法, 根据客户端的参数来创建接口
     * @param type 客户端传入的选择创建接口的条件
     * @return 创建好的Api对象
     */
    public static Api createApi(int type) {//注意这里添加了参数

        /*
        这里的type也可以不由外部传入，而是直接读取配置文件来获取
        为了把注意力放在模式本身，这里就不去写读取配置文件的代码了
        根据type来进行选择，当然这里的1和2应该作为常量
         */
        Api api = null;
        if (type == 1) {
            api = new Impl();
        } else if (type == 2) {
            api = new Impl2();
        }
        /*每次新增加一个实现类都来修改工厂类的实现，肯定不是一个好的实现方式
        一个解决办法：使用配置文件，使用反射，IoC/DI
        else if (type == 3) {
            api = new Impl3();*/
        return api;
    }
}
