package es.kiwi.Structural.decorator.solution.sample;

/**
 * 装饰器的具体实现对象，向组件对象添加职责
 */
public class ConcreteDecoratorA extends Decorator{
    /**
     * 构造方法，传入组件对象
     *
     * @param component 组件对象
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    private String addedState;

    public String getAddedState() {
        return addedState;
    }

    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }

    @Override
    public void operation() {
        //调用父类的方法，可以再调用前后执行一些附加动作
        //在这里进行处理的时候，可以使用添加的状态
        super.operation();
    }
}
