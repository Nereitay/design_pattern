package es.kiwi.behavioral.strategy.example1;

/**
 * 价格管理，主要完成计算向客户所报价格的功能
 */
public class Price {
    /**
     * 报价，对不同类型的，计算不同的价格
     *
     * @param goodsPrice   商品销售原价
     * @param customerType 客户类型
     * @return 计算出来的，应该给客户报的价格
     */
    public double quote(double goodsPrice, String customerType) {
        if ("普通客户".equals(customerType)) {
            System.out.println("对于新客户或者是普通客户，没有折扣");
            return goodsPrice;
        } else if ("老客户".equals(customerType)) {
            System.out.println("对于老客户，统一折扣5%");
            return goodsPrice * (1 - 0.05);
        } else if ("大客户".equals(customerType)) {
            System.out.println("对于大客户，统一折扣10%");
            return goodsPrice * (1 - 0.1);
        }
        //其余人员都是报原价
        return goodsPrice;
    }
}