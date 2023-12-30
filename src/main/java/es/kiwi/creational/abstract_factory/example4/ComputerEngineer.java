package es.kiwi.creational.abstract_factory.example4;

/**
 * <p>添加新的接口</p>
 * 装机工程师的类
 */
public class ComputerEngineer {
    /**
     * 定义组装机器需要的CPU
     */
    private CPUApi cpu;
    /**
     * 定义组装机器需要的主板
     */
    private MainboardApi mainboard;

    private MemoryApi memory;

    /**
     * 🧠装机过程
     * @param schema 客户选择的装机方案
     */
    public void makeComputer(AbstractFactory schema) {
        //1：首先准备好装机所需要的配件
        prepareHardwares(schema);
        //2：组装机器

        //3：测试机器

        //4：交付客户
    }

    /**
     * 准备装机所需要的配件
     * @param schema 客户选择的装机方案
     */
    private void prepareHardwares(AbstractFactory schema) {
        //这里要去准备CPU和主板的具体实现，为了示例简单，这里只准备这两个
        //可是，装机工程师并不知道如何去创建，怎么办呢？

        //🧠使用抽象工厂来获取相应的接口对象
        this.cpu = (CPUApi) schema.createProduct(1);
        this.mainboard = (MainboardApi) schema.createProduct(2);
        this.memory = (MemoryApi) schema.createProduct(3);

        //测试一下配件是否好用
        this.cpu.calculate();
        this.mainboard.installCPU();
        if (memory != null) { //🧠 为了要同时满足以前和现在的要求，如果是以前客户端，它调用的时候没有内存
            this.memory.cacheData();
        }
    }
}
