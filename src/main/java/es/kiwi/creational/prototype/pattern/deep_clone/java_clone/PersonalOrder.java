package es.kiwi.creational.prototype.pattern.deep_clone.java_clone;

import es.kiwi.creational.prototype.pattern.java_clone.OrderApi;
import lombok.Getter;
import lombok.Setter;

/**
 * 个人订单对象,利用java的Clone功能 (浅度克隆 shallow clone)
 */
@Getter
@Setter
public class PersonalOrder implements Cloneable, OrderApi {

    private String customerName;
    private Product product = null;
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
        //重要改变：新的clone方法的实现
        PersonalOrder obj = null;

        try {
            obj = (PersonalOrder) super.clone();
            //下面一句话不可少
            obj.setProduct((Product) this.product.clone());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public String toString() {
        return "PersonalOrder{" +
                "订购产品是='" + this.product.getName() + '\'' +
                ", 订购数量为=" + this.orderProductNum +
                '}';
    }
}
