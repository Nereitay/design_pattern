package es.kiwi.structural.facade.example2;

/**
 * 对于一个子系统而言，外观类不需要很多，通常可以实现成为一个单例
 */
public class FacadeSingleton {

    private FacadeSingleton(){}
    public static void test() {
        AModuleImpl a = new AModuleImpl();
        a.testA();
        BModuleImpl b = new BModuleImpl();
        b.testB();
        CModuleImpl c = new CModuleImpl();
        c.testC();
    }
}
