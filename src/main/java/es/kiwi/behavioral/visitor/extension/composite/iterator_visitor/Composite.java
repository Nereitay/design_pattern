package es.kiwi.behavioral.visitor.extension.composite.iterator_visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合对象，可以包含其他组合对象或者叶子对象
 * 相当于访问者模式的具体Element实现对象
 */
public class Composite extends Component {
    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponents = new ArrayList<>();

    /**
     * 组合对象的名字
     */
    private String name = "";

    /**
     * 构造方法，传入组合对象的名字
     * @param name 组合对象名字
     */
    public Composite(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addChild(Component child) {
        childComponents.add(child);
    }

    /*以前迭代子元素的代码需要去除*/
    @Override
    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitComposite(this);
    }

    /*新加的方法*/
    public List<Component> getChildComponents() {
        return childComponents;
    }
}
