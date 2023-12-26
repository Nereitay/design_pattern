package es.kiwi.structural.adapter.example5;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 日志数据对象
 */
@Getter
@Setter
@ToString
public class LogModel implements Serializable {

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
