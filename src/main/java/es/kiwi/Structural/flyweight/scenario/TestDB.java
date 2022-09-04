package es.kiwi.Structural.flyweight.scenario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 供测试用，在内存中模拟数据库中的值
 */
public class TestDB {
    /**
     * 用来存放授权数据的值
     */
    public static List<String> dbList = new ArrayList<>();

    static {
        //通过静态代码块来填充模拟的数据
        dbList.add("Uva,人员列表,查看");
        dbList.add("Papaya,人员列表,查看");
        dbList.add("Papaya,薪资数据,查看");
        dbList.add("Papaya,薪资数据,修改");
        //添加更多的授权数据
        for (int i = 0; i < 3; i++) {
            dbList.add("Uva" + i + ",人员列表,查看");
        }
    }
}
