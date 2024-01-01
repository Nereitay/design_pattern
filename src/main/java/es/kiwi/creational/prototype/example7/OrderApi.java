package es.kiwi.creational.prototype.example7;

/**
 * <p>Java中的深度克隆</p>
 * 订单的接口
 */
public interface OrderApi {
    /**
     * 获取订单产品数量
     *
     * @return 订单中产品数量
     */
    int getOrderProductNum();

    /**
     * 设置订单产品数量
     *
     * @param num 订单产品数量
     */
    void setOrderProductNum(int num);

}
