package es.kiwi.creational.prototype.example5;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人订单对象,利用Java的Clone功能
 */
@Getter
@Setter
@ToString
public class PersonalOrder implements OrderApi, Cloneable {// 实现Cloneable接口
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


    @Override
    protected Object clone() throws CloneNotSupportedException { // 🐻‍❄️注意这里实现的变化
        return super.clone();
    }
}
