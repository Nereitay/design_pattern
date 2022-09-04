package es.kiwi.Structural.decorator.extension.object_composite_inheritance;
/*可以组合拥有多个对象的功能*/
public class C4 {

    private A a = new A();
    private B b = new B();

    public void a1() {
        //转调A对象的功能
        a.a1();
    }

    public void b1() {
        //转调B对象的功能
        b.b1();
    }

    public void c11() {
        System.out.println("Now in C3.c11");
    }
}
