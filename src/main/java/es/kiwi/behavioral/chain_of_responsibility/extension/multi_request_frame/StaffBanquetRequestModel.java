package es.kiwi.behavioral.chain_of_responsibility.extension.multi_request_frame;

/**
 * 封装和聚餐费用申请业务相关的请求数据
 */
public class StaffBanquetRequestModel extends RequestModel{
    /**
     * 约定具体的业务类型
     */
    public static final String FEE_TYPE = "banquet";

    /*
     * 调用父类的构造方法，约定好业务类型
     */
    public StaffBanquetRequestModel() {
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
