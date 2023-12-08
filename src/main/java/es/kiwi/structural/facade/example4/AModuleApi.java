package es.kiwi.structural.facade.example4;


public interface AModuleApi {
    // 对子系统外部
    void a1();
    /*这些方法是用在子系统内部，与B,C模式交互用*/
    void a2();
    void a3();
}
