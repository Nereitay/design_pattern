package es.kiwi.structural.adapter.scenario;

import java.util.List;

/**
 * （第一版文件存储）日志文件操作接口
 */
public interface LogFileOperateApi {
    /**
     * 读取日志文件，从文件按里面获取存储的日志列表对象
     * @return 存储的日志列表对象
     */
    List<LogModel> readLogFile();

    /**
     * 写日志文件，把日志文件写出到日志文件中去
     * @param list 要写到日志文件的日志列表
     */
    void writeLogFile(List<LogModel> list);
}
