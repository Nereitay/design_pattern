package es.kiwi.structural.decorator.example4;
/**
 * 使用装饰模式解决问题的思路
 * <p>对象组合 - 更灵活 1. 选择复用 2. 转调前后实现一些功能处理 3.可以组合拥有多个对象的功能</p>
 */
public class C2 {
	/**
	 * 创建A对象的实例
	 */
	private A a = new A();

	public void a1(){
		//转调A对象的功能
		a.a1();
		/*大家想想，在转调前后是不是还可以做些功能处理呢？
		* 对于A对象是不是透明呢？
		* */
	}
	public void c11(){
		System.out.println("now in C2.c11");
	}
}