package es.kiwi.Structural.facade.extension.facade_interface;

/**
 * A模块接口
 */
public interface AModuleApi {
    /*
    对子系统外部
     */
    void a1();
    /*
    对子系统内部，与B、C模块交互用
     */
    void a2();
    void a3();
}
