package es.kiwi.structural.facade.example2;

public class BModuleImpl implements BModuleApi {
    /**
     * 示意方法，B模块对外的一个功能方法
     */
    @Override
    public void testB() {
        System.out.println("现在在B模块里面操作testB方法");
    }
}
