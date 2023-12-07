package es.kiwi.behavioral.visitor.example6;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>遍历元素的方法放到访问者中</p>
 * 组合对象，可以包含其它组合对象或者叶子对象，
 * 相当于访问者模式的具体Element实现对象
 */
public class Composite extends Component {
    /**
     * 接受访问者的访问
     *
     * @param visitor 访问者对象
     */
    @Override
    public void accept(Visitor visitor) { // 注意这里循环让所有子元素都接受访问
        //回调访问者对象的相应方法
        visitor.visitComposite(this);
       /*以前迭代子元素的代码需要去除*/
    }

    /*新加的方法*/
    public List<Component> getChildComponents() {
        return childComponents;
    }

    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponents = new ArrayList<Component>();
    /**
     * 组合对象的名字
     */
    private String name = "";

    /**
     * 构造方法，传入组合对象的名字
     *
     * @param name 组合对象的名字
     */
    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void addChild(Component child) {
        childComponents.add(child);
    }

    public String getName() {
        return name;
    }
}
