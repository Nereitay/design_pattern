package es.kiwi.behavioral.strategy.example4;

/**
 * 具体算法实现，为新客户或者是普通客户计算应报的价格
 */
public class NormalCustomerStrategy implements Strategy {
    /**
     * 计算应报的价格
     *
     * @param goodsPrice 商品销售原价
     * @return 计算出来的，应该给客户报的价格
     */
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于新客户或者是普通客户，没有折扣");
        return goodsPrice;
    }
}
