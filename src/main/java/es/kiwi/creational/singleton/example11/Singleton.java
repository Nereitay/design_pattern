package es.kiwi.creational.singleton.example11;

/**
 * 使用枚举来实现单例模式的示例
 */
public enum Singleton {
    /**
     * 定义一个枚举的元素,它就代表了Singleton的一个实例
     */
    uniqueInstance;

    /**
     * 示意方法，单例可以有自己的操作
     */
    public void singletonOperation() {
        //功能处理
    }
}

/*
* 使用枚举类实现单实例控制会更加简洁，而且无偿提供了序列化的机制，
* 并由JVM从根本上提供保障，绝对防止多次实例化，时更简洁、高效、安全的实现单例的方式
* */
