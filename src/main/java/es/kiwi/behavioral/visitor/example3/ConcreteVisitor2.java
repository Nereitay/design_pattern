package es.kiwi.behavioral.visitor.example3;

/**
 * 具体的访问者实现
 */
public class ConcreteVisitor2 implements Visitor {
    /**
     * 访问元素A，相当于给元素A添加访问者的功能
     *
     * @param elementA 元素A的对象
     */
    @Override
    public void visitConcreteElementA(ConcreteElementA elementA) {
        //把去访问ConcreteElementA时，需要执行的功能实现在这里
        //可能需要访问元素已有的功能，比如：
        elementA.operationA();
    }

    /**
     * 访问元素B，相当于给元素B添加访问者的功能
     *
     * @param elementB 元素B的对象
     */
    @Override
    public void visitConcreteElementB(ConcreteElementB elementB) {
        //把去访问ConcreteElementB时，需要执行的功能实现在这里
        //可能需要访问元素已有的功能，比如：
        elementB.operationB();
    }
}
