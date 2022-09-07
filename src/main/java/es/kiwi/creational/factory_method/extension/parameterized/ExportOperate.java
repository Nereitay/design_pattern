package es.kiwi.creational.factory_method.extension.parameterized;

import es.kiwi.creational.factory_method.solution.ExportDB;
import es.kiwi.creational.factory_method.scenario.ExportFileApi;
import es.kiwi.creational.factory_method.solution.ExportTxtFile;

/**
 * 实现导出数据的业务功能对象,
 *
 * 不再是抽象类
 * 并不是说参数化工厂方法就不能实现成为抽象类了。只是一般情况下，参数化工厂方法，在父类都会提供默认的实现
 */
public class ExportOperate {

    /**
     * 工厂方法，创建导出的文件对象的接口对象
     * @param type 用户选择的导出类型
     * @return 导出文件对象的接口对象
     *
     * 不再抽象了，要提供默认的实现，根据传入导出类型来选择已有的实现
     */
    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;
        //根据类型来选择究竟要创建哪一种导出文件对象
        if (type == 1)
            api = new ExportTxtFile();
        else if (type == 2)
            api = new ExportDB();

        return api;
    }

    /**
     * 导出文件
     * @param type 用户选择的导出类型
     * @param data 需要保存的数据
     * @return 是否成功导出数据
     */
    public boolean export(int type,String data) {
        //使用工厂方法
        ExportFileApi api = factoryMethod(type);
        return api.export(data);
    }
}
