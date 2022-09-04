package es.kiwi.Structural.flyweight.extension.unshared;


import java.util.ArrayList;
import java.util.List;

/**
 * 不需要共享的flyweight对象
 * 也是组合模式中的组合对象
 */
public class UnsharedConcreteFlyweight implements Flyweight {
    /**
     * 记录每个组合对象所包含的子组件
     */
    private List<Flyweight> list = new ArrayList<>();

    @Override
    public void add(Flyweight f) {
        list.add(f);
    }

    @Override
    public boolean match(String securityEntity, String permit) {
        for (Flyweight f : list) {
            //递归调用
            if (f.match(securityEntity, permit)) {
                return true;
            }
        }
        return false;
    }
}
