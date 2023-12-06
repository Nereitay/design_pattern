package es.kiwi.structural.decorator.example6;

/**
 * 实现权限控制
 */
public class CheckDecorator extends Decorator {

    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param ebi 被装饰的对象
     */
    public CheckDecorator(GoodsSaleEbi ebi) {
        super(ebi);
    }

    /**
     * 保存销售信息，本来销售数据应该是多条，太麻烦了，为了演示，简单点
     *
     * @param user      操作人员
     * @param customer  客户
     * @param saleModel 销售数据
     * @return 是否保存成功
     */
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //简单点，只让张三执行这个功能
        if (!"张三".equals(user)) {
            System.out.println("对不起" + user + "，你没有保存销售单的权限");
            //就不再调用被装饰对象的功能了
            return false;
        } else {
            return this.ebi.sale(user, customer, saleModel);
        }
    }
}
