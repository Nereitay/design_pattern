package es.kiwi.creational.prototype.example6;

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

    private String customerName;
    private int orderProductNum = 0;

    /**
     * 🐻‍❄️产品对象
     */
    private Product product; // 增加的引用类型属性

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
     * 克隆方法
     *
     * @return 订单原型的实例
     */
    @Override
    public OrderApi cloneOrder() {
        //创建一个新的订单，然后把本实例的数据复制过去
        PersonalOrder order = new PersonalOrder();
        order.setCustomerName(this.customerName);
        order.setOrderProductNum(this.orderProductNum);
        //🐻‍❄️对于对象类型的数据，深度克隆的时候需要继续调用这个对象的克隆方法
        order.setProduct((Product) this.product.cloneProduct()); // 这里体现了深度克隆
        return order;
    }
}
