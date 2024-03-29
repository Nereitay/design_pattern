package es.kiwi.creational.singleton.example10;


public class Singleton {
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，
     * 而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static Singleton instance = new Singleton();

    }
    /**
     * 私有化构造方法
     */
    private Singleton(){}

    public static Singleton getInstance() {// 方法没有被同步，并且只是执行一个域的访问
        return SingletonHolder.instance;
    }

}
