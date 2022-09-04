package es.kiwi.Creational.abstract_factory.no_pattern;

import es.kiwi.Creational.abstract_factory.common.GAMainBoard;
import es.kiwi.Creational.abstract_factory.common.MSIMainBoard;
import es.kiwi.Creational.abstract_factory.common.MainBoardApi;

/**
 * 创建主板的简单工厂
 */
public class MainBoardFactory {
    /**
     * 创建主板接口对象的方法
     * @param type 选择CPU类型的参数
     * @return 主板接口对象的方法
     */
    public static MainBoardApi createMainBoardApi(int type) {
        MainBoardApi mainBoard = null;
        //根据参数来选择并创建相应的CPU对象
        if (type == 1)
            mainBoard = new GAMainBoard(1156);
        else if (type == 2)
            mainBoard = new MSIMainBoard(939);
        return mainBoard;
    }
}
