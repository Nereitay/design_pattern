package es.kiwi.structural.facade.example4;

/**
 * Facade实现成为interface的附带好处：
 * 选择性地暴露接口
 * 用于子系统内部的接口功能就不用暴露给子系统外部了
 */
public interface FacadeApi {
    /*
    这些是 A B1 C 模块对子系统外的接口，这样外部就不需要知道 A B1 C模块的存在，
    只需要知道Facade接口就行了
    */
    void a1();
    void b1();
    void c1();

    // 这是对外提供的组合方法，跟前面的例子中的Facade类里面的方法一样
    void test();
}
