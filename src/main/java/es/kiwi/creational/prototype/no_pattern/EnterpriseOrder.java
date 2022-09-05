package es.kiwi.creational.prototype.no_pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * 企业订单对象
 */
@Getter
@Setter
public class EnterpriseOrder implements OrderApi{
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

    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    @Override
    public void setOrderProductNum(int num) {
        this.orderProductNum = num;
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
