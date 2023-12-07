package es.kiwi.behavioral.visitor.example1;

import lombok.Data;
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
     * 企业客户提出服务请求的方法，示意一下
     */
    @Override
    public void serviceRequest() {
        //企业客户提出的具体服务请求
        System.out.println(this.getName() + "企业提出服务请求");
    }
}
