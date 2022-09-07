package es.kiwi.creational.abstract_factory.extension.scalable;

import es.kiwi.creational.abstract_factory.scenario.GAMainBoard;
import es.kiwi.creational.abstract_factory.scenario.IntelCPU;

/**
 * 装机方案三：Intel的CPU + 技嘉的主板 + 现代的内存
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema3 implements AbstractFactory {

    @Override
    public Object createProduct(int type) {
        Object retObj = null;

        //type 为1表示创建CPU，type为2表示创建主板， type为3表示创建内存
        if (type ==  1)
            retObj = new IntelCPU(1156);
        else if (type == 2)
            retObj = new GAMainBoard(1156);
        //创建新添加的产品
        else if (type == 3)
            retObj = new HyMemory();

        return retObj;
    }
}
