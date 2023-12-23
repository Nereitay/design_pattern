package es.kiwi.behavioral.command.example7;

public class Client {
    public static void main(String[] args) {
        // 先要启动后台，让整个程序运行起来
        CookManager.runCookManager();

        // 为了简单，直接循环模拟多个桌号点菜
        for (int i = 0; i < 5; i++) {
            // 创建服务员
            Waiter waiter = new Waiter();
            // 创建命令对象，就是要点的菜
            PotCommand pot = new PotCommand(i);
            DuckCommand duck = new DuckCommand(i);
            // 点菜，就是把这些菜让服务员记录下来
            waiter.orderDish(pot);
            waiter.orderDish(duck);
            // 点菜完毕
            waiter.orderOver();
        }
    }
}
/*
* 对于扩展日志请求，在高级应用中，可以扩展到事务处理中，
* 因为事务的基本实现机制就是先写日志，然后再操作数据库
* */
