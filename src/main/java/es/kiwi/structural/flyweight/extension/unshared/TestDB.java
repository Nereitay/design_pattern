package es.kiwi.structural.flyweight.extension.unshared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供测试用，在内存中模拟数据库中的值
 */
public class TestDB {
    /**
     * 用来存放单独授权数据的值
     */
    public static List<String> dbList = new ArrayList<>();

    /**
     * key为组合书记的id, value为该组合包含的多条授权数据的值
     */
    public static Map<String, String[]> dbMap = new HashMap<>();

    static {
        //通过静态代码块来填充模拟的数据，增加一个标识来表明是否组合授权数据
        dbList.add("Uva,人员列表,查看,1");
        dbList.add("Papaya,人员列表,查看,1");
        dbList.add("Papaya,操作薪资数据,,2");

        dbMap.put("操作薪资数据", new String[]{"薪资数据,查看", "薪资数据,修改"});

        //添加更多的授权数据
        for (int i = 0; i < 3; i++) {
            dbList.add("Uva" + i + ",人员列表,查看,1");
        }
    }
}
