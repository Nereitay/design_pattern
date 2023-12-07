package es.kiwi.behavioral.chain_of_responsibility.example5;

import lombok.Getter;
import lombok.Setter;

/**
 * 封装跟聚餐费用申请业务相关的请求数据
 */
@Getter
@Setter
public class FeeRequestModel extends RequestModel {

    /**
     * 约定具体的业务类型
     */
    public static final String FEE_TYPE = "fee";

    /**
     * 通过构造方法把具体的业务类型传递进来
     */
    public FeeRequestModel() {
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
