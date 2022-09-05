package es.kiwi.creational.factory_method.factorymethod_ioc_di.setter;

public class A {
    /**
     * 等待被注入进来
     */
    private C c = null;

    public void setC(C c) {
        this.c = c;
    }

    public void t1() {
        /*这里需要使用C, 可是又不让主动去创建C, 怎么办？
        反正就要求从外部注入，这样更省心
        自己不用管怎么获取C，直接使用就好了setter
         */

        c.tc();
    }
}
