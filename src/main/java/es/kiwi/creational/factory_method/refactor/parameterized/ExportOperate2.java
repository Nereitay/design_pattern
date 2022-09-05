package es.kiwi.creational.factory_method.refactor.parameterized;

import es.kiwi.creational.factory_method.refactor.ExportFileApi;

/**
 * 扩展ExportOperate对象，加入剋导出的XML文件
 */
public class ExportOperate2  extends ExportOperate{

    /**
     * 覆盖父类的工厂方法，创建导出的文件对象的接口对象
     * @param type 用户选择的导出类型
     * @return 导出文件对象的接口对象
     */
    @Override
    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;
        //可以全部覆盖，也可以选择自己感兴趣的覆盖
        //这里只想添加自己新的实现，其他的不管
        if (type == 3)
            api = new ExportXml();
        else
            api = super.factoryMethod(type);
        return api;
    }
}
