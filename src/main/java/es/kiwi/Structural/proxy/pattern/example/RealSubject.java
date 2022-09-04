package es.kiwi.Structural.proxy.pattern.example;

/**
 * 具体的目标对象，是真正被代理的对象
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        //执行具体的功能处理
    }
}
