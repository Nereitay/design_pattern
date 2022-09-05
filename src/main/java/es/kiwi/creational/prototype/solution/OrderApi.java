package es.kiwi.creational.prototype.solution;

/**
 * 订单的接口，声明了可以克隆自身的方法
 */
public interface OrderApi {

    int getOrderProductNum();

    void setOrderProductNum(int num);

    /**
     * 克隆方法
     *
     * @return 订单原型的实例
     */
    OrderApi cloneOrder();
}
