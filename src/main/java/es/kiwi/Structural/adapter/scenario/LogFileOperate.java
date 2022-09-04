package es.kiwi.Structural.adapter.scenario;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;

/**
 * 实现对日志文件的操作
 */
public class LogFileOperate implements LogFileOperateApi {
    /**
     * 日志文件的路径和文件名称，默认是当前项目根下的AdapterLog.log
     */
    private String logFilePathName = "AdapterLog.log";

    /**
     * 构造方法，传入文件的路径和名称
     * @param logFilePathName
     */
    public LogFileOperate(String logFilePathName) {
        /*
        先判断是否传入了文件的路径和名称，如果是，就重新设置操作的日志文件的路径和名称
         */
        if (StringUtils.isNotBlank(logFilePathName)) {
            this.logFilePathName = logFilePathName;
        }

    }

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> list = null;
        ObjectInputStream ois = null;

        try {
            File file = new File(logFilePathName);
            if (file.exists()) {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file)));
                list = (List<LogModel>) ois.readObject();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void writeLogFile(List<LogModel> list) {
        File file = new File(logFilePathName);
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
