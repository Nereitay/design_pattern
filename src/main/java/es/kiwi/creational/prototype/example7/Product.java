package es.kiwi.creational.prototype.example7;

import es.kiwi.creational.prototype.example6.ProductPrototype;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>Java中的深度克隆</p>
 * 产品对象
 */
@Getter
@Setter
@ToString
public class Product implements Cloneable {// 第一个变化：不再实现自己的接口了
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品名称
     */
    private String name;

    /*重要变化：不再自己一个一个属性地赋值了，直接调用super.clone()*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
