package es.kiwi.structural.decorator.example2;

/**
 * 装饰器接口，维持一个指向组件对象的接口对象，
 * 并定义一个与组件接口一致的接口
 */
public abstract class Decorator extends Component {
    /**
     * 持有组件对象,也就是被装饰的对象
     * 注意：这个被装饰的对象不一定是最原始的那个对象了，也可能是被其他装饰器装饰过后的对象，
     * 反正都是实现的同一个接口，也就是同一类型
     */
    protected Component component;

    /**
     * 构造方法，传入组件对象
     *
     * @param component 组件对象
     */
    public Decorator(Component component) {
        this.component = component;
    }

    /**
     * 示例方法
     */
    @Override
    public void operation() {
        //转发请求给组件对象，可以在转发前后执行一些附加动作
        component.operation();
    }
}
