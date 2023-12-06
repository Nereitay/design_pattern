package es.kiwi.structural.decorator.example4;

/**
 * 使用装饰模式解决问题的思路
 * <p>继承 - 非常不灵活的复用方式</p>
 */
public class C1 extends A {
    public void c11() {
        System.out.println("now in C1.c11");
    }
}