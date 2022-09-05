package es.kiwi.behavioral.strategy.solution;

/**
 * 具体算法实现，为老客户计算应报的价格
 */
public class OldCustomerStrategy implements Strategy{
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于老客户，统一折扣 5% ");
        return goodsPrice * (1 - 0.05);
    }
}
