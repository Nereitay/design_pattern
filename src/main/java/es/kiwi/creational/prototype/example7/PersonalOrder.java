package es.kiwi.creational.prototype.example7;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人订单对象
 */
@Getter
@Setter
@ToString
public class PersonalOrder implements OrderApi, Cloneable {// 实现的接口发生了改变

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

    /*重要改变：新的clone方法的实现*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        PersonalOrder obj = null;
        obj = (PersonalOrder) super.clone();
        //🧠下面这一句话不可少
        obj.setProduct((Product) this.product.clone());

        return obj;
    }
}
