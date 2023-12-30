package es.kiwi.creational.factory_method.example7;

/**
 * <P>扩展新的实现</P>
 * 导出成xml文件的对象
 */
public class ExportXml implements ExportFileApi {
    /**
     * 导出内容成为文件
     *
     * @param data 示意：需要保存的数据
     * @return 是否导出成功
     */
    @Override
    public boolean export(String data) {
        //简单示意一下
        System.out.println("导出数据" + data + "到XML文件");
        return true;
    }
}
