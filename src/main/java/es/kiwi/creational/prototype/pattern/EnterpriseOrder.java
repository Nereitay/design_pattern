package es.kiwi.creational.prototype.pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * 企业订单对象
 */
@Getter
@Setter
public class EnterpriseOrder implements OrderApi {

    private String enterpriseName;
    private String productId;
    private int orderProductNum = 0;

    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    @Override
    public void setOrderProductNum(int num) {
        this.orderProductNum = num;
    }

    @Override
    public OrderApi cloneOrder() {
        //创建一个新的订单，然后把本实例的数据复制过去
        EnterpriseOrder order = new EnterpriseOrder();
        order.setEnterpriseName(this.enterpriseName);
        order.setProductId(this.productId);
        order.setOrderProductNum(this.orderProductNum);

        return order;
    }

    @Override
    public String toString() {
        return "EnterpriseOrder{" +
                "企业订单的订购企业是='" + enterpriseName + '\'' +
                ", 订购产品是='" + productId + '\'' +
                ", 订购数量为=" + orderProductNum +
                '}';
    }
}
