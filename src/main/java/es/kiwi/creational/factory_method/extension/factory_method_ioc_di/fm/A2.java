package es.kiwi.creational.factory_method.extension.factory_method_ioc_di.fm;

public class A2 extends A1{
    @Override
    protected C1 createC1() {
        return new C2();
    }
}
