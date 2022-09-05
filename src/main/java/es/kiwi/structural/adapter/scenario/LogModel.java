package es.kiwi.structural.adapter.scenario;

import lombok.Data;

import java.io.Serializable;

/**
 * 日志数据对象
 */
@Data
public class LogModel implements Serializable {

    private static final long serialVersionUID = 9185030034088618267L;
    /**
     * 日志编号
     */
    private String logId;

    /**
     * 操作人员
     */
    private String operateUser;

    /**
     * 操作时间，以yyyy-MM-dd HH:mm:ss的格式记录
     */
    private String operateTime;

    /**
     * 日志内容
     */
    private String logContent;
}
