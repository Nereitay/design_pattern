package es.kiwi.Behavioral.strategy.extension.context_strategy;
/**
 * 扩展示例，实现方式二
 * 支付到银行卡
 */
public class Card2 implements PaymentStrategy{
    /**
     * 账号信息
     */
    private String account;

    /**
     * 构造方法，传入账号信息
     * @param account 账号信息
     */
    public Card2(String account) {
        this.account = account;
    }

    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("现在给" + ctx.getUsername() + "的" + this.account + "账号支付了" + ctx.getMoney() + "元");
        //连接银行，进行转账，就不去管了
    }
}
