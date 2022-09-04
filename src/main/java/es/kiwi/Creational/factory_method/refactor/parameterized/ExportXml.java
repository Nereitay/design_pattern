package es.kiwi.Creational.factory_method.refactor.parameterized;

import es.kiwi.Creational.factory_method.refactor.ExportFileApi;

/**
 * 导出成xml文件的对象
 */
public class ExportXml implements ExportFileApi {
    @Override
    public boolean export(String data) {
        // 简单示意一下
        System.out.println("导出数据" + data + "到XML文件");
        return true;
    }
}
