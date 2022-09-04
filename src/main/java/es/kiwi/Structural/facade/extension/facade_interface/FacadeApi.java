package es.kiwi.Structural.facade.extension.facade_interface;

public interface FacadeApi {
    //这些是A B C模块对子系统外的接口，这样外部就不需要知道ABC模块的存在，只需要知道facade接口就行
    void a1();
    void b1();
    void c1();
    //这是对外提供组合的方法，跟前面的例子中的Facade类里面的方法一样
    void test();
}
