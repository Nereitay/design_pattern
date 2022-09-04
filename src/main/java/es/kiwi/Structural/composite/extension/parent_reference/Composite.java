package es.kiwi.Structural.composite.extension.parent_reference;


import java.util.ArrayList;
import java.util.List;

/**
 * 组合对象， 可以包含其他组和对象或者叶子对象
 */
public class Composite extends Component {

    private List<Component> childComponents;

    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void printStruct(String preStr) {
        //先把自己输出去
        System.out.println(preStr + "+" + this.name);
        //如果还包含有子组件，那么就输出这些子组件对象
        /*新的实现*/
        if (this.childComponents != null) {
            //添加一个空格，表示向后缩进一个空格
            preStr += " ";
            //输出当前对象的子对象
            for (Component c : childComponents) {
                //递归输出每个子对象
                c.printStruct(preStr);
            }
        }

    }

    /*---------------------以上是原有的实现， 没有变化----------------------*/


    @Override
    public void addChild(Component child) {
        //延迟初始化
        if (childComponents == null) {
            childComponents = new ArrayList<>();
        }

        childComponents.add(child);

        //添加对父组件的引用
        child.setParent(this);
    }

    @Override
    public void removeChild(Component child) {
        if (childComponents != null) {
            //查找到要删除的组件在集合中的索引位置
            int idx = childComponents.indexOf(child);
            if (idx != -1) {
                //先把被删除的商品类别对象的父商品类别设置成为被删除的商品类别的子类别的父商品类别
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

    @Override
    public List<Component> getChildren() {
        return childComponents;
    }
}
