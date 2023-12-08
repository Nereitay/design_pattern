package es.kiwi.structural.facade.example2;

public class AModuleImpl implements AModuleApi {
    /**
     * 示意方法，A模块对外的一个功能方法
     */
    @Override
    public void testA() {
        System.out.println("现在在A模块里面操作testA方法");
    }
}
