package es.kiwi.creational.factory_method.example6;
/**
 * <p>工厂方法模式和IoC/DI的思想类似</p>
 * 工厂方法示例代码
 */
public abstract class B1 {
    /**
     * 工厂方法，创建D1，类似于从子类注入进来的途径
     * @return D1的对象实例
     */
    protected abstract D1 createD1();

    public void t1() {
        //这里需要使用D1，可是不知道究竟是用哪一个，也就不主动去创建D1了，怎么办？
        //反正会在子类里面实现，这样更省心，这里不用管怎么获取D1，直接使用就好了
        createD1().tc();
    }
}
