package es.kiwi.behavioral.strategy.example5;

/**
 * <p>扩展示例，实现方式二:
 * 通过策略的构造方法来传入新算法需要的数据，
 * 这样实现的话，就不需要扩展上下文了，直接添加新的策略算法实现就可以了
 * </p>
 * 支付到银行卡
 */
public class Card2 implements PaymentStrategy {

    private String account;

    public Card2(String account) {
        this.account = account;
    }

    /**
     * 公司给某人真正支付工资
     *
     * @param ctx 支付工资的上下文，里面包含算法需要的数据
     */
    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("现在给" + ctx.getUserName() + "的" + this.account + "帐号支付了" + ctx.getMoney() + "元");
        //连接银行，进行转帐，就不去管了
    }
}
