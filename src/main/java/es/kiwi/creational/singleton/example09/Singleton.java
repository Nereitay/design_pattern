package es.kiwi.creational.singleton.example09;

/**
 * 双重检查加锁
 */
public class Singleton {
    /**
     * 对保存实例的变量添加volatile的修饰
     */
    private static volatile Singleton instance;

    private Singleton() {
    }


    public static Singleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            /*它只是在第一次创建实例的时候同步，以后就不需要同步了，从而加快了运行速度*/
            //同步块，线程安全的创建实例
            synchronized (Singleton.class) {
                //再次检查实例是否存在，如果不存在才真的创建实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
