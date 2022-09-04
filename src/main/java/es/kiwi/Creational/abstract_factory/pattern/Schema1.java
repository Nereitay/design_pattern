package es.kiwi.Creational.abstract_factory.pattern;

import es.kiwi.Creational.abstract_factory.common.CPUApi;
import es.kiwi.Creational.abstract_factory.common.GAMainBoard;
import es.kiwi.Creational.abstract_factory.common.IntelCPU;
import es.kiwi.Creational.abstract_factory.common.MainBoardApi;

/**
 * 装机方案一：Intel的CPU + 技嘉的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema1 implements AbstractFactory{
    @Override
    public CPUApi createCPUApi() {
        return new IntelCPU(1156);
    }

    @Override
    public MainBoardApi createMainBoardApi() {
        return new GAMainBoard(1156);
    }
}
