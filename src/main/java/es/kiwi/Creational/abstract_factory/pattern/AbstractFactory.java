package es.kiwi.Creational.abstract_factory.pattern;

import es.kiwi.Creational.abstract_factory.common.CPUApi;
import es.kiwi.Creational.abstract_factory.common.MainBoardApi;

/**
 * 抽象工厂的接口，声明创建抽象产品对象的操作
 */
public interface AbstractFactory {
    /**
     * 创建CPU对象
     * @return 创建CPU对象
     */
    CPUApi createCPUApi();
    /**
     * 创建主板对象
     * @return 创建主板对象
     */
    MainBoardApi createMainBoardApi();
}
