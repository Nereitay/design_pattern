package es.kiwi.Structural.decorator.extension.object_composite_inheritance;

public class C2 {
    /**
     * 创建A对象的实例
     */
    private A a = new A();

    public void a1() {
        //转调A对象的功能
        a.a1();
    }

    public void c11() {
        System.out.println("Now in C2.c11");
    }
}
