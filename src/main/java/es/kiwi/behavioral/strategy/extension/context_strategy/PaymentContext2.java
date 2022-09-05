package es.kiwi.behavioral.strategy.extension.context_strategy;

/**
 * 扩展的支付上下文对象
 */
public class PaymentContext2 extends PaymentContext{
    /**
     * 银行账号
     */
    private String account;

    /**
     * 构造方法，传入被支付工资的人员，应支付的金额和具体的支付策略
     *
     * @param username 被支付工资的人员
     * @param money    应支付的金额
     * @param account 支付到的银行账号
     * @param strategy 具体的支付策略
     */
    public PaymentContext2(String username, double money, String account, PaymentStrategy strategy) {
        super(username, money, strategy);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
}
