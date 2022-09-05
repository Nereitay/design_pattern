package es.kiwi.creational.prototype.extension.deep_clone;

import es.kiwi.creational.prototype.solution.OrderApi;
import lombok.Getter;
import lombok.Setter;

/**
 * 个人订单对象 (浅度克隆)
 */
@Getter
@Setter
public class PersonalOrder implements OrderApi {

    private String customerName;
    private int orderProductNum = 0;
    /**
     * 增加的引用类型属性：产品对象
     */
    private Product product = null;

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
        order.setOrderProductNum(this.orderProductNum);
        //对于对象类型的数据，深度克隆的时候需要调用这个对象的克隆方法
        order.setProduct((Product) this.product.cloneProduct());

        return order;
    }

    @Override
    public String toString() {
        return "PersonalOrder{" +
                "订购产品是='" + this.product.getName() + '\'' +
                ", 订购数量为=" + this.orderProductNum +
                '}';
    }
}
