package es.kiwi.creational.singleton.solution.sample.enumeration;

/**
 * 使用枚举类来实现单例模式的示例
 *  更加简洁并且无偿提供了序列化机制，并由JVM从根本上保障，绝对防止多次实例化
 *
 */
public enum Singleton {
    /**
     * 定义一个枚举的元素，他就代表了Singleton的一个实例
     */
    uniqueInstance;

    /**
     * 示意方法，单例可以有自己的操作
     */
    public void singletonOperation(){
        //功能处理
    }
}
