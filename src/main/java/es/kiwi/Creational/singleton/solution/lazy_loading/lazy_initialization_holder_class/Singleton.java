package es.kiwi.Creational.singleton.solution.lazy_loading.lazy_initialization_holder_class;

/**
 * Lazy initialization holder class模式
 *      综合使用java的类级内部类和多线程缺省同步锁的知识，巧妙地同时实现了延迟加载和线程安全
 */
public class Singleton {
    /**
     * 类级内部类，也就是静态的成员式内部类。该内部类的实例与外部类的实例没有绑定关系，而且只有被调用到时才会装载。从而实现了延迟加载
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static Singleton instance = new Singleton();
    }

    /**
     * 私有化构造方法
     */
    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
