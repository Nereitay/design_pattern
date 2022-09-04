package es.kiwi.Creational.factory_method.refactor.parameterized;

import es.kiwi.Creational.factory_method.refactor.ExportDB;
import es.kiwi.Creational.factory_method.refactor.ExportFileApi;
import es.kiwi.Creational.factory_method.refactor.ExportTxtFile;

/**
 * 实现导出数据的业务功能对象,
 *
 * 不再是抽象类
 */
public class ExportOperate {

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
}
