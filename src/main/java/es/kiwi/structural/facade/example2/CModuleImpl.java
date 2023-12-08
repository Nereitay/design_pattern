package es.kiwi.structural.facade.example2;

public class CModuleImpl implements CModuleApi {
    /**
     * 示意方法，C模块对外的一个功能方法
     */
    @Override
    public void testC() {
        System.out.println("现在在C模块里面操作testC方法");
    }
}
