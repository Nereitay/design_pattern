package es.kiwi.Creational.abstract_factory.pattern;

import es.kiwi.Creational.abstract_factory.common.*;

/**
 * 装机方案一：AMD的CPU + 微星的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema2 implements AbstractFactory{
    @Override
    public CPUApi createCPUApi() {
        return new AMDCPU(939);
    }

    @Override
    public MainBoardApi createMainBoardApi() {
        return new MSIMainBoard(939);
    }
}
