package es.kiwi.behavioral.chain_of_responsibility.extension.multi_request_frame_extended;

import es.kiwi.behavioral.chain_of_responsibility.extension.multi_request_frame.RequestModel;

public class PrepaidTravelExpensesRequestModel extends RequestModel {
    public static final String FEE_TYPE = "travel";
    /**
     * 通过构造方法把具体的业务类型传递进来
     *
     * @param type 具体的业务类型
     */
    public PrepaidTravelExpensesRequestModel() {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
