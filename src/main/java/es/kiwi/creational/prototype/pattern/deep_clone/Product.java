package es.kiwi.creational.prototype.pattern.deep_clone;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品对象
 */
@Getter
@Setter
public class Product implements ProductPrototype{
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品名称
     */
    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "产品编号='" + productId + '\'' +
                ", 产品名称='" + name + '\'' +
                '}';
    }

    @Override
    public ProductPrototype cloneProduct() {
        //创建一个新的订单，然后把本实例的数据复制过去
        Product product = new Product();
        product.setProductId(this.productId);
        product.setName(this.name);
        return product;
    }
}
