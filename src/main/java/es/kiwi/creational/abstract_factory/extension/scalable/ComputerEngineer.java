package es.kiwi.creational.abstract_factory.extension.scalable;

import es.kiwi.creational.abstract_factory.scenario.CPUApi;
import es.kiwi.creational.abstract_factory.scenario.MainBoardApi;

public class ComputerEngineer {
    private CPUApi cpu = null;
    private MainBoardApi mainBoard = null;

    /**
     * 定义组装电脑需要的内存
     */
    private MemoryApi memory = null;

    public void makeHardware(AbstractFactory schema) {
        prepareHardware(schema);
    }

    private void prepareHardware(AbstractFactory schema) {
        //这里要去准备CPU和主板的具体事项，为了示例简单，这里只准备这两个
        //可是，装机工程师并不知道如何去创建，怎么办呢？

        //使用抽象工厂来获取相应的接口对象
        this.cpu = (CPUApi) schema.createProduct(1);
        this.mainBoard = (MainBoardApi) schema.createProduct(2);
        this.memory = (MemoryApi) schema.createProduct(3);

        //测试一下配件是否好用
        this.cpu.calculate();
        this.mainBoard.installCPU();
        if (memory != null)
            this.memory.cacheData();
    }


}
