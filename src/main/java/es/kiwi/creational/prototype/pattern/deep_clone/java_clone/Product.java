package es.kiwi.creational.prototype.pattern.deep_clone.java_clone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product implements Cloneable {
    private String productId;
    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "产品编号='" + productId + '\'' +
                ", 产品名称='" + name + '\'' +
                '}';
    }

    @Override
    public Object clone() {

        Object obj = null;

        try {
            //重要变化：不在自己一个一个属性地赋值了，直接调用super.clone()
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
