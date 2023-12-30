package es.kiwi.creational.factory_method.example3;

/**
 * 导出成数据库备份文件形式的对象
 */
public class ExportDB implements ExportFileApi {
    /**
     * 导出内容成为文件
     *
     * @param data 示意：需要保存的数据
     * @return 是否导出成功
     */
    @Override
    public boolean export(String data) {
        //简单示意一下，这里需要操作数据库和文件
        System.out.println("导出数据" + data + "到数据库备份文件");
        return true;
    }
}
