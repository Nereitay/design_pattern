package es.kiwi.creational.factory_method.example8;

/**
 * 导出成文本文件格式的对象
 */
public class ExportTxtFile implements ExportFileApi {
    /**
     * 导出内容成为文件
     *
     * @param data 示意：需要保存的数据
     * @return 是否导出成功
     */
    @Override
    public boolean export(String data) {
        //简单示意一下，这里需要操作文件
        System.out.println("导出数据" + data + "到文本文件");
        return true;
    }
}
