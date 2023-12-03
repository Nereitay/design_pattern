package es.kiwi.behavioral.strategy.example5;

/**
 * 美元现金支付
 */
public class DollarCash implements PaymentStrategy {
    /**
     * 公司给某人真正支付工资
     *
     * @param ctx 支付工资的上下文，里面包含算法需要的数据
     */
    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("现在给" + ctx.getUserName() + "美元现金支付" + ctx.getMoney() + "元");
    }
}
