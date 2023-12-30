package es.kiwi.creational.factory_method.example6;

public class B2 extends B1 {
    /**
     * 工厂方法，创建D1，类似于从子类注入进来的途径
     *
     * @return D1的对象实例
     */
    @Override
    protected D1 createD1() {
        //真正的选择具体实现，并创建对象
        return new D2();
    }
}
