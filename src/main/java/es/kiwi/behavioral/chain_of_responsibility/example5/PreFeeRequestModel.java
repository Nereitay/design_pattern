package es.kiwi.behavioral.chain_of_responsibility.example5;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>演示在不改变现有框架下，扩展新业务</p>
 * 封装跟预支差旅费申请业务相关的请求数据
 */
@Getter
@Setter
public class PreFeeRequestModel extends RequestModel {
    /**
     * 约定具体的业务类型
     */
    public static final String FEE_TYPE = "preFee";

    /**
     * 通过构造方法把具体的业务类型传递进来
     */
    public PreFeeRequestModel() {
        super(FEE_TYPE);
    }

    /**
     * 申请人
     */
    private String user;
    /**
     * 申请金额
     */
    private double fee;
}
