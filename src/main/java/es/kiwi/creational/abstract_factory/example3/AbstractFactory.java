package es.kiwi.creational.abstract_factory.example3;

/**
 * <p>使用抽象工厂重写示例</p>
 * 抽象工厂的接口，声明创建抽象产品对象的操作
 */
public interface AbstractFactory {
    /**
     * 创建CPU的对象
     *
     * @return CPU的对象
     */
    CPUApi createCPUApi();

    /**
     * 创建主板的对象
     *
     * @return 主板的对象
     */
    MainboardApi createMainboardApi();
}
