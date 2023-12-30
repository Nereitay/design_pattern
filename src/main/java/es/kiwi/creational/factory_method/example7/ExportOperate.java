package es.kiwi.creational.factory_method.example7;

/**
 * <p>参数化工厂方法</p>
 * 实现导出数据的业务功能对象
 */
public class ExportOperate { // 不再是抽象类

    /**
     * 导出文件
     *
     * @param type 用户选择的导出类型
     * @param data 需要保存的数据
     * @return 是否成功导出文件
     */
    public boolean export(int type, String data) {// 传入参数
        //使用工厂方法
        ExportFileApi api = factoryMethod(type);
        return api.export(data);
    }

    /**
     * 工厂方法，创建导出的文件对象的接口对象
     * @param type 用户选择的导出类型
     * @return 导出的文件对象的接口对象
     */
    protected ExportFileApi factoryMethod(int type) { //不再是抽象了，要提供默认的实现，根据传入的导出类型来选择已有的实现
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
