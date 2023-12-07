package es.kiwi.behavioral.visitor.example4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 各种客户的父类
 */
@Getter
@Setter
@ToString
public abstract class Customer {
    /**
     * 客户编号
     */
    private String customerId;
    /**
     * 客户名称
     */
    private String name;

    /**
     * 接受访问者的访问
     *
     * @param visitor 访问者对象
     */
    public abstract void accept(Visitor visitor);
}
