package es.kiwi.structural.composite.extension.parent_reference;

import java.util.List;

/*父组件的引用*/
public abstract class Component {

    /**
     * 记录父组件对象
     */
    private Component parent;

    /**
     * 获取一个组件的父组件对象
     * @return 一个组件的父组件对象
     */
    public Component getParent() {
        return parent;
    }

    /**
     * 设置一个组件的父组件对象
     * @param parent 一个组件的父组件对象
     */
    public void setParent(Component parent) {
        this.parent = parent;
    }

    /**
     * 返回某个组件的子组件对象
     * @return 某个组件的子组件对象
     */
    public List<Component> getChildren() {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /*------------------以下是原有的定义----------------------*/

    public abstract void printStruct(String preStr);

    public void addChild(Component child) {
        // 缺省的实现，抛出例外，因为叶子对象没有这个功能， 或者子组件没有实现这个功能
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    public void removeChild(Component child) {
        // 缺省的实现，抛出例外，因为叶子对象没有这个功能， 或者子组件没有实现这个功能
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    public Component getChildren(int index) {
        // 缺省的实现，抛出例外，因为叶子对象没有这个功能， 或者子组件没有实现这个功能
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
}
