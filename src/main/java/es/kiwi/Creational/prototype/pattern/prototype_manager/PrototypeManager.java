package es.kiwi.Creational.prototype.pattern.prototype_manager;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型管理器
 */
public class PrototypeManager {
    /**
     * 用来记录原型的编号和原型实例的对应关系
     */
    private static Map<String, Prototype> map = new HashMap<>();

    /**
     * 私有化构造方法，避免外部无谓的创建实例
     */
    private PrototypeManager() {
        //
    }

    /**
     * 向原型管理器里面添加或是修改某个原型注册
     * @param prototypeId 原型编号
     * @param prototype 原型实例
     */
    public synchronized static void setPrototype(String prototypeId, Prototype prototype) {
        map.put(prototypeId, prototype);
    }

    /**
     * 从原型管理器里面删除某个原型注册
     * @param prototypeId 原型编号
     */
    public synchronized static void removePrototype(String prototypeId) {
        map.remove(prototypeId);
    }

    /**
     * 获取某个原型编号对应的原型实例
     * @param prototypeId 原型编号
     * @return 圆形编号对应的原型实例
     * @throws Exception 如果原型编号对应的原型实例不存在，抛出异常
     */
    public synchronized static Prototype getPrototype(String prototypeId) throws Exception {
        Prototype prototype = map.get(prototypeId);
        if (prototype == null) {
            throw new Exception("您希望获取的原型还没有注册或已被销毁");
        }

        return prototype;
    }
}
