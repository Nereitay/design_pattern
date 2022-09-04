package es.kiwi.Structural.flyweight.extension.unshared;

import java.util.HashMap;
import java.util.Map;

/**
 * 不需要变化
 * 享元工厂，通常是实现成为单例
 */
public class FlyweightFactory {

    private static FlyweightFactory factory = new FlyweightFactory();

    private FlyweightFactory() {}

    public static FlyweightFactory getInstance() {
        return factory;
    }

    private Map<String, Flyweight> fsMap = new HashMap<>();

    /**
     * 获取key对应的享元对象
     *
     * 外部通过这个方法来获取享元对象
     * @param key 获取享元对象的key
     * @return key对应的享元对象
     */
    public Flyweight getFlyweight(String key) {
        Flyweight f = fsMap.get(key);
        if (f == null) {
            f = new AuthorizationFlyweight(key);
            fsMap.put(key, f);
        }
        return f;
    }
}
