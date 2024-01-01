package es.kiwi.creational.prototype.example6;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 产品对象
 */
@Getter
@Setter
@ToString
public class Product implements ProductPrototype {
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品名称
     */
    private String name;

    /**
     * 克隆产品自身的方法
     *
     * @return 一个从自身克隆出来的产品对象
     */
    @Override
    public ProductPrototype cloneProduct() {
        //创建一个新的订单，然后把本实例的数据复制过去
        Product product = new Product();
        product.setProductId(this.productId);
        product.setName(this.name);
        return product;
    }
}
