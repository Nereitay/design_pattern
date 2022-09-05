package es.kiwi.creational.prototype.no_pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * 个人订单对象
 */
@Getter
@Setter
public class PersonalOrder implements OrderApi{
    /**
     * 订购人员姓名
     */
    private String customerName;
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
        return "PersonalOrder{" +
                "个人订单的订购人是='" + customerName + '\'' +
                ", 订购产品是='" + productId + '\'' +
                ", 订购数量为=" + orderProductNum +
                '}';
    }
}
