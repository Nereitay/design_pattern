package es.kiwi.behavioral.strategy.example5;

public class Client {
	public static void main(String[] args) {
		//创建相应的支付策略
		PaymentStrategy strategyRMB = new RMBCash();
		PaymentStrategy strategyDollar = new DollarCash();
		
		//准备小李的支付工资上下文
		PaymentContext ctx1 = new PaymentContext("小李",5000,strategyRMB);
		//向小李支付工资
		ctx1.payNow();
		
		//切换一个人，给petter支付工资
		PaymentContext ctx2 = new PaymentContext("Petter",8000,strategyDollar);
		ctx2.payNow();

		/*两种扩展实现方式
		* 1. 扩展上下文 风格更统一，但容易形成复杂的上下文对象层次；数据有些浪费
		* 2. 在策略方法的实现上添加自己需要的数据方式 简单但风格不统一，难于以一个统一的方式来动态切换策略方式
		* */
		//测试新添加的支付方式
		PaymentStrategy strategyCard = new Card();
		PaymentContext ctx3 = new PaymentContext2("小王",9000,"010998877656",strategyCard);
		ctx3.payNow();
		
		//测试新添加的支付方式
		PaymentStrategy strategyCard2 = new Card2("010998877656");
		PaymentContext ctx4 = new PaymentContext("小张",9000,strategyCard2);
		ctx4.payNow();
	}
}