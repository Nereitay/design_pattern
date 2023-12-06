package es.kiwi.structural.decorator.example4;
/**
 * 使用装饰模式解决问题的思路
 * <p>对象组合 3.可以组合拥有多个对象的功能</p>
 */
public class C3 {
	private A a = new A();
	private B b = new B();

	public void a1(){
		//转调A对象的功能
		a.a1();
	}
	public void b1(){
		//转调B对象的功能
		b.b1();
	}

	public void c11(){
		System.out.println("now in C3.c11");
	}
}