package es.kiwi.behavioral.state.extension.workflow;

/**
 * 请假单业务数据模型
 */
public class LeaveRequestModel {

    private String user;

    private String beginDate;

    private int LeaveDays;

    private String result;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public int getLeaveDays() {
        return LeaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        LeaveDays = leaveDays;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
