package es.kiwi.behavioral.state.example7;

import lombok.Getter;
import lombok.Setter;

/**
 * 请假单对象
 */
@Getter
@Setter
public class LeaveRequestModel {
    /**
     * 请假人
     */
    private String user;
    /**
     * 请假开始时间
     */
    private String beginDate;
    /**
     * 请假天数
     */
    private int leaveDays;
    /**
     * 审核结果
     */
    private String result;
}
