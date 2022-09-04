package es.kiwi.Structural.composite.extension.circular_reference;


public abstract class Component {

    /**
     * 记录每个组件的路径
     */
    private String componentPath;

    /**
     * 获取组件的路径
     * @return 组件的路径
     */
    public String getComponentPath() {
        return componentPath;
    }

    /**
     * 设置组件的路径
     * @param componentPath 组件的路径
     */
    public void setComponentPath(String componentPath) {
        this.componentPath = componentPath;
    }

    /**
     * 获取组件的名称
     * @return 组件的名称
     */
    public abstract String getName();

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
