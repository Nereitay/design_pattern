package es.kiwi.behavioral.visitor.example4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 企业客户
 */
@Getter
@Setter
@ToString(callSuper = true)
public class EnterpriseCustomer extends Customer {
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 联系电话
     */
    private String linkTelephone;
    /**
     * 企业注册地址
     */
    private String registerAddress;


    /**
     * 接受访问者的访问
     *
     * @param visitor 访问者对象
     */
    @Override
    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitEnterpriseCustomer(this);
    }
}
