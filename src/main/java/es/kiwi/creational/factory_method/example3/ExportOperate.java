package es.kiwi.creational.factory_method.example3;

/**
 * <p>使用工厂方法模式来实现示例</p>
 * 实现导出数据的业务功能对象
 */
public abstract class ExportOperate {

    /**
     * 导出文件
     *
     * @param data 需要保存的数据
     * @return 是否成功导出文件
     */
    public boolean export(String data) {
        //使用工厂方法
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }

    /**
     * 工厂方法，创建导出的文件对象的接口对象
     *
     * @return 导出的文件对象的接口对象
     */
    protected abstract ExportFileApi factoryMethod();
}
