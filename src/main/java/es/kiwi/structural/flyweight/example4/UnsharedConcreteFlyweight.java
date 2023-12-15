package es.kiwi.structural.flyweight.example4;

import java.util.ArrayList;
import java.util.List;

/**
 * 不需要共享的享元对象的实现，也是组合模式中的组合对象
 */
public class UnsharedConcreteFlyweight implements Flyweight {
    /**
     * 记录每个组合对象所包含的子组件
     */
    private List<Flyweight> list = new ArrayList<>();

    /**
     * 为flyweight添加子flyweight对象
     *
     * @param f 被添加的子flyweight对象
     */
    @Override
    public void add(Flyweight f) {
        list.add(f);
    }

    /**
     * 判断传入的安全实体和权限，是否和享元对象内部状态匹配
     *
     * @param securityEntity 安全实体
     * @param permit         权限
     * @return true表示匹配，false表示不匹配
     */
    @Override
    public boolean match(String securityEntity, String permit) {
        for (Flyweight f : list) {
            // 递归调用
            if (f.match(securityEntity, permit)) {
                return true;
            }
        }
        return false;
    }
}
