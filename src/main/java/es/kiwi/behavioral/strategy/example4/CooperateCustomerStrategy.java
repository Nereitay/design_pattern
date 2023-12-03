package es.kiwi.behavioral.strategy.example4;

/**
 * <p>演示增加新策略</p>
 * 具体算法实现，为战略合作客户客户计算应报的价格
 */
public class CooperateCustomerStrategy implements Strategy {
    /**
     * 计算应报的价格
     *
     * @param goodsPrice 商品销售原价
     * @return 计算出来的，应该给客户报的价格
     */
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于战略合作客户，统一8折");
        return goodsPrice * 0.8;
    }
}
