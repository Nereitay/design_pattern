package es.kiwi.creational.singleton.example05;

/**
 * 懒汉式
 */
public class Singleton {
    //4：定义一个变量来存储创建好的类实例
    //5：因为这个变量要在静态方法中使用，所以需要加上static修饰
    private static Singleton uniqueInstance;// 这个属性就是用来缓存实例的

    //1：私有化构造方法，好在内部控制创建实例的数目
    private Singleton() {
        //
    }

    //2：定义一个方法来为客户端提供类实例
    //3：这个方法需要定义成类方法，也就是要加static
    public static synchronized Singleton getInstance() {
        /*缓存的实现*/
        //6：判断存储实例的变量是否有值
        if (uniqueInstance == null) {
            //6.1：如果没有，就创建一个类实例，并把值赋值给存储类实例的变量
            uniqueInstance = new Singleton();
        }
        //6.2：如果有值，那就直接使用
        return uniqueInstance;
    }

}
