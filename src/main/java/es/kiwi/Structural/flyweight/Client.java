package es.kiwi.Structural.flyweight;

import es.kiwi.Structural.flyweight.extension.object_manage.FlyweightFactory;
import es.kiwi.Structural.flyweight.scenario.SecurityMgr;

public class Client {

    public static void main(String[] args) {
        /*加入权限控制场景*/
//        scenario();

        /*使用享元模式重写示例*/
//        flyweight();

        /*不需要共享的享元实现*/
//        unshared();

        /*对享元对象的管理：引用计数，垃圾清理*/
        es.kiwi.Structural.flyweight.extension.object_manage.SecurityMgr mgr =
                es.kiwi.Structural.flyweight.extension.object_manage.SecurityMgr.getInstance();
        boolean f1 = mgr.hasPermit("Uva", "薪资数据", "查看");
        boolean f2 = mgr.hasPermit("Papaya", "薪资数据", "查看");
        boolean f3 = mgr.hasPermit("Papaya", "薪资数据", "修改");

        for (int i = 0; i < 3; i++) {
            mgr.hasPermit("Uva" + i, "薪资数据", "查看");
        }

        //特别提醒，这里查看的引用次数，不是指测试使用的次数，指的是SecurityMgr的queryByUser方法通过享元工厂去获取享元对象的次数
        System.out.println("薪资数据,查看 被引用了" + FlyweightFactory.getInstance().getUseTimes("薪资数据,查看") + "次");
        System.out.println("薪资数据,修改 被引用了" + FlyweightFactory.getInstance().getUseTimes("薪资数据,修改") + "次");
        System.out.println("人员列表,查看 被引用了" + FlyweightFactory.getInstance().getUseTimes("人员列表,查看") + "次");


    }

    private static void unshared() {
        es.kiwi.Structural.flyweight.extension.unshared.SecurityMgr mgr =
                es.kiwi.Structural.flyweight.extension.unshared.SecurityMgr.getInstance();
        mgr.login("Uva");
        mgr.login("Papaya");
        boolean f1 = mgr.hasPermit("Uva", "薪资数据", "查看");
        boolean f2 = mgr.hasPermit("Papaya", "薪资数据", "查看");
        boolean f3 = mgr.hasPermit("Papaya", "薪资数据", "修改");

        System.out.println("f1===" + f1);
        System.out.println("f2===" + f2);
        System.out.println("f3===" + f3);
        for (int i = 0; i < 3; i++) {
            mgr.login("Uva" + i);
            mgr.hasPermit("Uva" + i, "薪资数据", "查看");
        }
    }

    private static void flyweight() {
        es.kiwi.Structural.flyweight.solution.SecurityMgr mgr =
                es.kiwi.Structural.flyweight.solution.SecurityMgr.getInstance();
        mgr.login("Uva");
        mgr.login("Papaya");
        boolean f1 = mgr.hasPermit("Uva", "薪资数据", "查看");
        boolean f2 = mgr.hasPermit("Papaya", "薪资数据", "查看");

        System.out.println("f1===" + f1);
        System.out.println("f2===" + f2);
        for (int i = 0; i < 3; i++) {
            mgr.login("Uva" + i);
            mgr.hasPermit("Uva" + i, "薪资数据", "查看");
        }
    }

    private static void scenario() {
        //需要先登录，然后再判断是否有权限
        SecurityMgr mgr = SecurityMgr.getInstance();
        mgr.login("Uva");
        mgr.login("Papaya");
        boolean f1 = mgr.hasPermit("Uva", "薪资数据", "查看");
        boolean f2 = mgr.hasPermit("Papaya", "薪资数据", "查看");

        System.out.println("f1===" + f1);
        System.out.println("f2===" + f2);
        for (int i = 0; i < 3; i++) {
            mgr.login("Uva" + i);
            mgr.hasPermit("Uva" + i, "薪资数据", "查看");
        }
    }
}
