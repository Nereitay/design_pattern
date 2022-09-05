package es.kiwi.behavioral.strategy.solution;

/**
 * 策略，定义计算报价算法的接口
 */
public interface Strategy {
    /**
     * 计算应报的价格
     * @param goodsPrice 商品销售原价
     * @return
     */
    double calcPrice(double goodsPrice);
}
