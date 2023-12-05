package es.kiwi.structural.composite.example5;

/**
 * 抽象的组件对象，安全性的实现方式
 */
public abstract class Component {
    /**
     * 输出组件自身的名称
     */
    public abstract void printStruct(String preStr); // 相当于模式示例代码中的样例方法

    /*Component中不再定义管理和操作子组件的方法
    * 把相应的方法都删除了
    * */

    /**
     * 解决类型转换不安全的问题
     * @param component
     * @return
     */
    public Composite getComposite(Component component) {
        if (component instanceof Composite) {
            return (Composite) component;
        }

        return null;
    }
}
