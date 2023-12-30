package es.kiwi.creational.abstract_factory.example3;

/**
 * 装机方案一：Intel 的CPU + 技嘉的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema1 implements AbstractFactory {
    /**
     * 创建CPU的对象
     *
     * @return CPU的对象
     */
    @Override
    public CPUApi createCPUApi() {
        return new IntelCPU(1156);
    }

    /**
     * 创建主板的对象
     *
     * @return 主板的对象
     */
    @Override
    public MainboardApi createMainboardApi() {
        return new GAMainboard(1156);
    }
}
