package es.kiwi.Creational.simple_factory.solution;

/**
 * 工厂类，用来创建api对象
 *  简单工厂能帮助我们真正地开始面向接口编程，像以前的做法，其实只是用到了接口的多态部分的功能，而最重要的封装隔离性并没有体现出来
 */
public class Factory {

    public static Api createApi(int condition) {
        /*
        应该根据某些条件去选择究竟创建哪一个具体的实现对象
            这些条件可以从外部传入，也可以从其他途径获取
         */
        Api api = null;
        if (condition == 1)
            api = new ImplA();
        else if (condition == 2)
            api = new ImplB();
        return api;
    }
}
