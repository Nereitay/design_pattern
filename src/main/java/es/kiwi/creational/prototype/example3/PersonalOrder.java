package es.kiwi.creational.prototype.example3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人订单对象
 */
@Getter
@Setter
@ToString
public class PersonalOrder implements OrderApi {
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
        PersonalOrder order = new PersonalOrder();
        order.setCustomerName(this.customerName);
        order.setProductId(this.productId);
        order.setOrderProductNum(this.orderProductNum);
        return order;
    }
}
