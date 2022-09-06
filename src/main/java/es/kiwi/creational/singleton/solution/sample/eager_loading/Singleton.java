package es.kiwi.creational.singleton.solution.sample.eager_loading;

/**
 * 饿汉式单例实现的示例，空间换时间
 */
public class Singleton {
    /*饿汉式是线程安全的，因为虚拟机只会装载一次，在装载类的时候是不会发生并发的*/
    /**
     * 4.定义一个静态变量来存储创建好的类实例，直接在这里创建类实例，只能创建一次
     * 这个方案用到了static特性（主动加static）
     * static变量在类加载的时候进行初始化
     * 多个实例的static变量会共享同一块内存区域
     */
    private static Singleton uniqueInstance = new Singleton();
    /**
     * 示意属性，单例可以有自己的属性
     */
    private String singletonData;

    /**
     * 1.私有化构造方法，可以在内部控制创建实例的数目
     */
    private Singleton() {
        //
    }

    /**
     * 2.定义一个方法来为客户端提供类实例
     * 3.这个方法需要定义成类方法，也就是要加static
     * @return 一个Singleton的实例
     *
     */
    public static Singleton getInstance() {
        //5.直接使用已经创建好的实例
        return uniqueInstance;
    }

    /**
     * 示意方法，单例可以有自己操作
     */
    public void singletonOperation() {
        //功能处理
    }


    /**
     * 示意方法，让外部通过这些方法来访问属性的值
     *
     * @return 属性的值
     */
    public String getSingletonData() {
        return singletonData;
    }
}
