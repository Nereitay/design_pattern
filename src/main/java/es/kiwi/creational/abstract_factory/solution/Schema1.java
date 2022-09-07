package es.kiwi.creational.abstract_factory.solution;

import es.kiwi.creational.abstract_factory.scenario.CPUApi;
import es.kiwi.creational.abstract_factory.scenario.GAMainBoard;
import es.kiwi.creational.abstract_factory.scenario.IntelCPU;
import es.kiwi.creational.abstract_factory.scenario.MainBoardApi;

/**
 * 装机方案一：Intel的CPU + 技嘉的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema1 implements AbstractFactory {
    @Override
    public CPUApi createCPUApi() {
        return new IntelCPU(1156);
    }

    @Override
    public MainBoardApi createMainBoardApi() {
        return new GAMainBoard(1156);
    }
}
