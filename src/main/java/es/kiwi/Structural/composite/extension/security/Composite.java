package es.kiwi.Structural.composite.extension.security;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合对象， 可以包含其他组和对象或者叶子对象, 需要继承组件对象
 */
public class Composite extends Component {

    /*这一个集合，代替了原来分开记录的两个集合*/
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
     * @param name 组合对象的名字
     */
    public Composite(String name) {
        this.name = name;
    }

   /*代替了原来的 addComposite 和 addLeaf 方法*/
    public void addChild(Component child) {
        //延迟初始化
        if (childComponents == null) {
            childComponents = new ArrayList<>();
        }

        childComponents.add(child);
    }

    /**
     * 输出组合对象自身的结构
     * @param preStr 前缀，主要是按照层级拼接的空格，实现向后缩进
     */
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


}
