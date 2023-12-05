package es.kiwi.structural.composite.example6;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合对象，可以包含其它组合对象或者叶子对象
 */
public class Composite extends Component {
    /**
     * 向组合对象中加入组件对象
     *
     * @param child 被加入组合对象中的组件对象
     */
    @Override
    public void addChild(Component child) {
        // 延迟初始化
        if (childComponents == null) {
            childComponents = new ArrayList<>();
        }
        childComponents.add(child);

        //添加对父组件的引用
        child.setParent(this);
    }

    /**
     * 从组合对象中移出某个组件对象
     *
     * @param child 被移出的组件对象
     */
    @Override
    public void removeChild(Component child) {
        if (childComponents != null) {
            // 查找到要删除的组件在集合中的索引位置
            int idx = childComponents.indexOf(child);
            if (idx != -1) {
                // 先把被删除的商品类别对象的父商品类别设置成为被删除的商品的子类别的父商品类别
                for (Component c : child.getChildren()) {
                    //删除的组件对象是本实例的一个子组件对象
                    c.setParent(this);
                    //把被删除的商品类别对象的子组件对象添加到当前实例中
                    childComponents.add(c);
                }
                //真的删除
                childComponents.remove(idx);
            }
        }
    }

    /**
     * 返回某个组件的子组件对象
     *
     * @return 某个组件的子组件对象
     */
    @Override
    public List<Component> getChildren() {
        return childComponents;
    }

    /*------------------以下是原有的实现，没有变化-----------------*/
    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponents;
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

    /**
     * 输出组合对象自身的结构
     *
     * @param preStr 前缀，主要是按照层级拼接的空格，实现向后缩进
     */
    @Override
    public void printStruct(String preStr) {
        //先把自己输出去
        System.out.println(preStr + "+" + this.name);
        /*新的实现*/
        //如果还包含有子组件，那么就输出这些子组件对象
        if (this.childComponents != null) {
            //然后添加一个空格，表示向后缩进一个空格
            preStr += "  ";
            //输出当前对象的子对象了
            for (Component c : childComponents) {
                //递归输出每个子对象
                c.printStruct(preStr);
            }
        }
    }
}
