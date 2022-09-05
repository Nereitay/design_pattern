package es.kiwi.structural.facade.solution.sample;

/**
 * 外观对象
 */
public class Facade {
    /**
     *对于一个子系统而言，外观类不需要很多，通常可以实现成为一个单例
     *  构造方法私有，提供静态方法
     */
    private Facade(){}

    /**
     * 示意方法：满足客户需要的功能
     */
    public static void test() {
        //在内部实现的时候，可能会调用到内部多个模块
        AModuleApi a = new AModuleImpl();
        a.testA();
        BModuleApi b = new BModuleImpl();
        b.testB();
        CModuleApi c = new CModuleImpl();
        c.testC();
    }
}
