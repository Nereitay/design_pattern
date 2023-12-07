package es.kiwi.behavioral.visitor.example2;

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
     * 客户提出服务请求的方法，示意一下
     */
    public abstract void serviceRequest();

    /*扩展客户管理的功能*/
    /**
     * 客户对公司产品的偏好分析，示意一下
     */
    public abstract void predilectionAnalyze();
    /**
     * 客户价值分析，示意一下
     */
    public abstract void worthAnalyze();
}
