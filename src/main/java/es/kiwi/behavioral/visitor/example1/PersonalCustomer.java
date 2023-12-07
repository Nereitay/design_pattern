package es.kiwi.behavioral.visitor.example1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人客户
 */
@Getter
@Setter
@ToString(callSuper = true)
public class PersonalCustomer extends Customer{
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 年龄
     */
    private int age;

    /**
     * 个人客户提出服务请求的方法，示意一下
     */
    @Override
    public void serviceRequest(){
        //个人客户提出的具体服务请求
        System.out.println("客户"+this.getName()+"提出服务请求");
    }
}
