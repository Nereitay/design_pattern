package es.kiwi.creational.prototype.solution;

import lombok.Getter;
import lombok.Setter;

/**
 * 个人订单对象 (浅度克隆)
 */
@Getter
@Setter
public class PersonalOrder implements OrderApi {

    private String customerName;
    private String productId;
    private int orderProductNum = 0;

    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    @Override
    public void setOrderProductNum(int num) {
        orderProductNum = num;
    }

    @Override
    public OrderApi cloneOrder() {
        //创建一个新的订单，然后把本实例的数据复制过去
        PersonalOrder order = new PersonalOrder();
        order.setCustomerName(this.customerName);
        order.setProductId(this.productId);
        order.setOrderProductNum(this.orderProductNum);

        return order;
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
