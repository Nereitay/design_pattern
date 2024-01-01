package es.kiwi.creational.prototype.example3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 企业订单对象
 */
@Getter
@Setter
@ToString
public class EnterpriseOrder implements OrderApi {
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 订单产品数量
     */
    private int orderProductNum = 0;

    /**
     * 获取订单产品数量
     *
     * @return 订单中产品数量
     */
    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    /**
     * 设置订单产品数量
     *
     * @param num 订单产品数量
     */
    @Override
    public void setOrderProductNum(int num) {
        this.orderProductNum = num;
    }

    /**
     * 🐻‍❄️克隆方法
     *
     * @return 订单原型的实例
     */
    @Override
    public OrderApi cloneOrder() {
        //创建一个新的订单，然后把本实例的数据复制过去
        EnterpriseOrder order = new EnterpriseOrder();
        order.setEnterpriseName(this.enterpriseName);
        order.setProductId(this.productId);
        order.setOrderProductNum(this.orderProductNum);
        return order;
    }
}
