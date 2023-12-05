package es.kiwi.structural.composite.example6;

import java.util.List;

/**
 * <p>父组件引用</p>
 * 抽象的组件对象
 */
public abstract class Component {
    /**
     * 记录父组件对象
     */
    private Component parent;

    /**
     * 获取一个组件的父组件对象
     *
     * @return 一个组件的父组件对象
     */
    public Component getParent() {
        return parent;
    }

    /**
     * 设置一个组件的父组件对象
     *
     * @param parent 一个组件的父组件对象
     */
    public void setParent(Component parent) {
        this.parent = parent;
    }

    /**
     * 返回某个组件的子组件对象
     *
     * @return 某个组件的子组件对象
     */
    public List<Component> getChildren() {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /*------------------以下是原有定义-----------------*/
    /**
     * 输出组件自身的名称
     */
    public abstract void printStruct(String preStr); // 相当于模式示例代码中的样例方法

    /*以下方法没有改变，和模式示例代码一样*/
    /**
     * 向组合对象中加入组件对象
     *
     * @param child 被加入组合对象中的组件对象
     */
    public void addChild(Component child) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 从组合对象中移出某个组件对象
     *
     * @param child 被移出的组件对象
     */
    public void removeChild(Component child) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 返回某个索引对应的组件对象
     *
     * @param index 需要获取的组件对象的索引，索引从0开始
     * @return 索引对应的组件对象
     */
    public Component getChildren(int index) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
}
