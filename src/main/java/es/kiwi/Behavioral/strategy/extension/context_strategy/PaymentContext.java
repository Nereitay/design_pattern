package es.kiwi.Behavioral.strategy.extension.context_strategy;

/**
 * 支付工资的上下文，每个人的工资不同，支付方式也不同
 */
public class PaymentContext {
    /**
     * 应被支付工资的人员，简单点，用姓名来代替
     */
    private String username;
    /**
     * 应被支付的工资金额
     */
    private double money;
    /**
     * 支付方式的策略接口
     */
    private PaymentStrategy strategy;

    /**
     * 构造方法，传入被支付工资的人员，应支付的金额和具体的支付策略
     * @param username 被支付工资的人员
     * @param money 应支付的金额
     * @param strategy 具体的支付策略
     */
    public PaymentContext(String username, double money, PaymentStrategy strategy) {
        this.username = username;
        this.money = money;
        this.strategy = strategy;
    }

    /*
    只有getter方法，让策略算法再实现的时候，根据需要来获取上下文中的数据
     */
    public String getUsername() {
        return username;
    }

    public double getMoney() {
        return money;
    }

    /**
     * 立即支付工资
     */
    public void payNow() {
        //使用客户希望的支付策略来支付工资
        this.strategy.pay(this);
    }
}
