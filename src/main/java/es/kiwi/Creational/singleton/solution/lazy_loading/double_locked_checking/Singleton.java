package es.kiwi.Creational.singleton.solution.lazy_loading.double_locked_checking;

/**
 * 双重检查加锁:既实现线程安全，又能使性能不受到很大的影响
 */
public class Singleton {
    /**
     * 对保存实例的变量添加volatile的修饰
     * 被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确处理该变量
     * 由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高，因此没有特别需要，不要使用
     */
    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        //先检查实力是否存在，如果不存在才进入下面的同步代码块
        if (instance == null) {
            //同步块，线程安全地创建实例
            synchronized (Singleton.class) {
                //再次检查实例是否存在，如果不存在才真正地创建实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
