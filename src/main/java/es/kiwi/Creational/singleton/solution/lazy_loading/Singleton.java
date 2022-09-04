package es.kiwi.Creational.singleton.solution.lazy_loading;

/**
 * 懒汉式单例实现的示例
 */
public class Singleton {
    /**
     * 4.定义一个变量来存储创建好的类实例
     * 5.由于要在一个静态方法里面使用，所以这个属性被迫称为一个类变量，要强制加上static，也就是说，这里并没有使用static的特性
     */
    private static Singleton uniqueInstance = null;
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
     *
     * @return 一个Singleton的实例
     */
    public static synchronized Singleton getInstance() {
        //6.判断存储实例的变量是否有值
        if (uniqueInstance == null) {
            //6.1如果没有，就创建一个类实例，并把值赋值给存储类实例的变量
            uniqueInstance = new Singleton();
        }

        //6.2如果有，那就直接使用
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
