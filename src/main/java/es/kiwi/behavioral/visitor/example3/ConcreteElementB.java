package es.kiwi.behavioral.visitor.example3;

/**
 * 具体元素的实现对象
 */
public class ConcreteElementB extends Element {
    /**
     * 接受访问者的访问
     *
     * @param visitor 访问者对象
     */
    @Override
    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitConcreteElementB(this);
    }
    /**
     * 示例方法，表示元素已有的功能实现
     */
    public void operationB() {
        //已有的功能实现
    }
}
