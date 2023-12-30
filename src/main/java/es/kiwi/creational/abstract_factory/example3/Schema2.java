package es.kiwi.creational.abstract_factory.example3;

/**
 * 装机方案二：AMD的CPU + 微星的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema2 implements AbstractFactory {
    /**
     * 创建CPU的对象
     *
     * @return CPU的对象
     */
    @Override
    public CPUApi createCPUApi() {
        return new AMDCPU(939);
    }

    /**
     * 创建主板的对象
     *
     * @return 主板的对象
     */
    @Override
    public MainboardApi createMainboardApi() {
        return new MSIMainboard(939);
    }
}
