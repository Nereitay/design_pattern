package es.kiwi.structural.adapter.example1;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 实现对日志文件的操作
 */
public class LogFileOperate implements LogFileOperateApi {
    /**
     * 日志文件的路径和文件名称，默认是当前classpath下的AdapterLog.log
     */
    private String logFilePathName = "AdapterLog.log";

    /**
     * 构造方法，传入文件的路径和名称
     *
     * @param logFilePathName 文件的路径和名称
     */
    public LogFileOperate(String logFilePathName) {
        //先判断是否传入了文件的路径和名称，如果是，就重新设置操作的日志文件的路径和名称
        if (StringUtils.isNotBlank(logFilePathName)) {
            this.logFilePathName = logFilePathName;
        }
    }

    /**
     * 读取日志文件，从文件里面获取存储的日志列表对象
     *
     * @return 存储的日志列表对象
     */
    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> list = null;
        try (ObjectInputStream oin = new ObjectInputStream(
                new BufferedInputStream(
                        Files.newInputStream(Paths.get(logFilePathName))))) {
            list = (List<LogModel>) oin.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 写日志文件，把日志列表写出到日志文件中去
     *
     * @param list 要写到日志文件的日志列表
     */
    @Override
    public void writeLogFile(List<LogModel> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        Files.newOutputStream(Paths.get(logFilePathName))))) {
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
