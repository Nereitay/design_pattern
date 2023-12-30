package es.kiwi.creational.factory_method.example8;

/**
 * <p>退化成简单工厂</p>
 * 实现导出数据的业务功能对象
 */
public class ExportOperate {
    /*只留下这一个方法，如果把它修改成 public static,
    * 是不是就和简单工厂写的一样了
    * */
    /**
     * 工厂方法，创建导出的文件对象的接口对象
     * @param type 用户选择的导出类型
     * @return 导出的文件对象的接口对象
     */
    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;
        //根据类型来选择究竟要创建哪一种导出文件对象
        if (type == 1) {
            api = new ExportTxtFile();
        } else if (type == 2) {
            api = new ExportDB();
        }
        return api;
    }
}
