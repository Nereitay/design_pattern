package es.kiwi.structural.proxy.example2;

/**
 * 具体的目标对象，是真正被代理的对象
 */
public class RealSubject implements Subject {
    /**
     * 示意方法：一个抽象的请求方法
     */
    @Override
    public void request() {
        //执行具体的功能处理
    }
}
