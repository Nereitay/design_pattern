package es.kiwi.creational.factory_method.extension.factory_method_ioc_di.fm;

public abstract class A1 {

    /**
     * 工厂方法，创建C1，类似于从子类注入进来的途径
     * @return C1的对象实例
     */
    protected abstract C1 createC1();

    public void t1() {
        //这里需要使用C1类，可是不知道究竟是用哪一个，也就不主动创建C1了，怎么办？
        //反正会在子类里面实现，这里不用管怎么获取C1，直接使用就好了
        createC1().tc();
    }
}
