package es.kiwi.creational.simple_factory.solution.sample;

/**
 * 工厂类，用来创建api对象
 *  简单工厂能帮助我们真正地开始面向接口编程，
 *  像以前的做法，其实只是用到了接口的多态部分的功能，而最重要的封装隔离性并没有体现出来
 */
public class Factory {

    /**
     * 具体创建Api对象的方法
     * @param condition 示意，从外部传入的选择条件
     * @return 创建好的Api对象
     */
    public static Api createApi(int condition) {
        /*
        应该根据某些条件去选择究竟创建哪一个具体的实现对象
            这些条件可以从外部传入，也可以从其他途径获取
            如果只有一个条件，可以省略条件，因为没有选择的必要
         */
        //示意使用条件
        Api api = null;
        if (condition == 1)
            api = new ImplA();
        else if (condition == 2)
            api = new ImplB();
        return api;
    }


}
