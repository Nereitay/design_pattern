package es.kiwi.behavioral.strategy.extension.context_strategy;

/**
 * 扩展示例，实现方式一
 * 支付到银行卡
 */
public class Card implements PaymentStrategy {
    @Override
    public void pay(PaymentContext ctx) {
        //这个新的算法自己要知道使用扩展上下文，所以强制造型一下
        PaymentContext2 ctx2 = (PaymentContext2) ctx;

        System.out.println("现在给" + ctx2.getUsername() + "的" + ctx2.getAccount() + "账号支付了" + ctx2.getMoney() + "元");

        //连接银行，进行转账，就不去管了
    }
}
