package es.kiwi.behavioral.command.example6;

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
* 仔细观察以上数据。在多线程的环境下，虽然保障了命令对象的顺序是先进先出，
* 但是究竟是哪一个厨师来做，还有具体做多长时间都是不定的。
* */
