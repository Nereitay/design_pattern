package es.kiwi.Creational.prototype.pattern.java_clone;

import lombok.Getter;
import lombok.Setter;

/**
 * 个人订单对象,利用java的Clone功能 (浅度克隆 shallow clone)
 */
@Getter
@Setter
public class PersonalOrder implements Cloneable, OrderApi {

    private String customerName;
    private String productId;
    private int orderProductNum = 0;

    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    public void setOrderProductNum(int num) {
        orderProductNum = num;
    }

    @Override
    public Object clone() {
        //克隆方法的真正实现，直接调用父类的克隆方法就可以了
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return obj;
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
