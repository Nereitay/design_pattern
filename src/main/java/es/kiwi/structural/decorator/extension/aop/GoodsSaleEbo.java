package es.kiwi.structural.decorator.extension.aop;

public class GoodsSaleEbo implements GoodsSaleEbi{
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        System.out.println(user + "保存了" + customer + "购买 " + saleModel + " 的销售数据");
        return true;
    }
}
