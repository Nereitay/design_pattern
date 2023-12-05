package es.kiwi.structural.composite.example7;

/**
 * <p>检测环状引用</p>
 * <p>有一些问题没有考虑：要是删除了路径上的某个组件对象，那么所有该组件对象的子组件对象所记录的路径，都需要修改，要把这个组件从所有相关路径上都删除
 * -- 就是在被删除的组件对象的所有子组件对象的路径上，查找到被删除组件的名称，然后通过字符串截取的方式将其删除 。。。。。。
 * </p>
 * 抽象的组件对象
 */
public abstract class Component {
    /**
     * 记录每个组件的路径
     */
    private String componentPath = "";

    /**
     * 获取组件的路径
     *
     * @return 组件的路径
     */
    public String getComponentPath() {
        return componentPath;
    }

    /**
     * 设置组件的路径
     *
     * @param componentPath 组件的路径
     */
    public void setComponentPath(String componentPath) {
        this.componentPath = componentPath;
    }

    /**
     * 获取组件的名称
     *
     * @return 组件的名称
     */
    public abstract String getName();

    /*---------------以下是原有的定义---------------*/

    /**
     * 输出组件自身的名称
     */
    public abstract void printStruct(String preStr); // 相当于模式示例代码中的样例方法

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
