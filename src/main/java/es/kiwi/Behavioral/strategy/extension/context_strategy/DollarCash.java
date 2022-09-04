package es.kiwi.Behavioral.strategy.extension.context_strategy;

/**
 * 人民币现金支付
 */
public class DollarCash implements PaymentStrategy {
    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("现在给" + ctx.getUsername() + "美元现金支付" + ctx.getMoney() + "元");
    }
}
