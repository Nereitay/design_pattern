package es.kiwi.structural.decorator.extension.aop;

/**
 * 实现权限控制
 */
public class CheckDecorator extends Decorator{
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param ebi 被装饰的对象
     */
    public CheckDecorator(GoodsSaleEbi ebi) {
        super(ebi);
    }

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //简单点，只让Mango执行这个功能
        if (!"Mango".equals(user)) {
            System.out.println("对不起" + user + "，你没有保存销售单的权限");
            //就不再调用被装饰对象的功能了
            return false;
        }
        return this.ebi.sale(user, customer, saleModel);
    }
}
