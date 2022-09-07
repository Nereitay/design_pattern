package es.kiwi.creational.factory_method.scenario;

/**
 * 导出的文件对象出口
 */
public interface ExportFileApi {
    /**
     * 导出内容成为文件
     * @param data 示意：需要保存的数据
     * @return 是否到处成功
     */
    boolean export(String data);
}
