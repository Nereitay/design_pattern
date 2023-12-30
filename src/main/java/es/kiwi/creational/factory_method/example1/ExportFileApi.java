package es.kiwi.creational.factory_method.example1;

/**
 * 导出的文件对象的接口
 */
public interface ExportFileApi {
    /**
     * 导出内容成为文件
     *
     * @param data 示意：需要保存的数据
     * @return 是否导出成功
     */
    boolean export(String data);
}
/*
* 问题：对于导出数据的业务功能对象，它需要创建ExportFileApi的具体实例对象，
* 但是它只知道ExportFileApi接口，而不知道其具体的实现，那该怎么办？
* */
