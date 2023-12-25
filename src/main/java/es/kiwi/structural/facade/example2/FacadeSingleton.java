package es.kiwi.structural.facade.example2;

/**
 * 对于一个子系统而言，外观类不需要很多，通常可以实现成为一个单例
 */
public class FacadeSingleton { // 把外观类当成一个辅助工具类实现

    private FacadeSingleton(){} // 私有化构造方法
    public static void test() { // 外观中的方法实现成为静态方法
        AModuleApi a = new AModuleImpl();
        a.testA();
        BModuleApi b = new BModuleImpl();
        b.testB();
        CModuleApi c = new CModuleImpl();
        c.testC();
    }
}
