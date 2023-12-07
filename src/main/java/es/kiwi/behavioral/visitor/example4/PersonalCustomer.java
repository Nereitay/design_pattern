package es.kiwi.behavioral.visitor.example4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人客户
 */
@Getter
@Setter
@ToString(callSuper = true)
public class PersonalCustomer extends Customer {
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 年龄
     */
    private int age;


    /**
     * 接受访问者的访问
     *
     * @param visitor 访问者对象
     */
    @Override
    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitPersonalCustomer(this);
    }
}
