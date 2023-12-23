package es.kiwi.behavioral.command.example6;

/**
 * 后厨的管理类，通过此类让后厨的厨师进行运行状态
 * 在这个类里面启动多个厨师的线程，而且这种启动在运行期间只有一次
 */
public class CookManager {
    /**
     * 用来控制是否需要创建厨师，如果已经创建过了就不要再执行了
     */
    private static boolean runFlag = false;

    /**
     * 运行厨师管理，创建厨师对象并启动他们相应的线程，
     * 无论运行多少次，创建厨师对象和启动线程的工作就只做一次
     */
    public static void runCookManager() {
        if (!runFlag) {
            runFlag = true;
            // 创建三位厨师
            HotCook cook1 = new HotCook("Apple");
            HotCook cook2 = new HotCook("Banana");
            HotCook cook3 = new HotCook("Cherry");

            //启动他们的线程
            Thread t1 = new Thread(cook1);
            t1.start();
            Thread t2 = new Thread(cook2);
            t2.start();
            Thread t3 = new Thread(cook3);
            t3.start();

        }
    }
}
