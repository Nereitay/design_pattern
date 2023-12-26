package es.kiwi.structural.adapter.example4;


import java.util.List;

/**
 * 👀双向适配器对象
 */
public class TwoDirectionAdapter implements LogDbOperateApi, LogFileOperateApi {// 实现需要适配的两个接口

    /*持有双向适配的日志接口对象*/
    /**
     * 持有需要被适配的文件存储日志的接口对象
     */
    private LogFileOperateApi fileLog;
    /**
     * 持有需要被适配的DB存储日志的接口对象
     */
    private LogDbOperateApi dbLog;

    /**
     * 构造方法，传入需要被适配的对象
     *
     * @param fileLog 需要被适配的文件存储日志的接口对象
     * @param dbLog   需要被适配的DB存储日志的接口对象
     */
    public TwoDirectionAdapter(LogFileOperateApi fileLog, LogDbOperateApi dbLog) {
        this.fileLog = fileLog;
        this.dbLog = dbLog;
    }

    /*-----以下是把DB操作的方式适配成为文件实现方式的接口-----*/

    /**
     * 读取日志文件，从文件里面获取存储的日志列表对象
     *
     * @return 存储的日志列表对象
     */
    @Override
    public List<LogModel> readLogFile() {
        return dbLog.getAllLog();
    }

    /**
     * 写日志文件，把日志列表写出到日志文件中去
     *
     * @param list 要写到日志文件的日志列表
     */
    @Override
    public void writeLogFile(List<LogModel> list) {
        //1：最简单的实现思路，先删除数据库中的数据
        //2：然后循环把现在的数据加入到数据库中
        for (LogModel lm : list) {
            dbLog.createLog(lm);
        }
    }

    /*-----以下是把文件操作的方式适配成为DB实现方式的接口-----*/

    /**
     * 新增日志
     *
     * @param lm 需要新增的日志对象
     */
    @Override
    public void createLog(LogModel lm) {
        //1：先读取文件的内容
        List<LogModel> list = fileLog.readLogFile();
        //2：加入新的日志对象
        list.add(lm);
        //3：重新写入文件
        fileLog.writeLogFile(list);
    }

    /**
     * 修改日志
     *
     * @param lm 需要修改的日志对象
     */
    @Override
    public void updateLog(LogModel lm) {
        //1：先读取文件的内容
        List<LogModel> list = fileLog.readLogFile();
        //2：修改相应的日志对象
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogId().equals(lm.getLogId())) {
                list.set(i, lm);
                break;
            }
        }
        //3：重新写入文件
        fileLog.writeLogFile(list);
    }

    /**
     * 删除日志
     *
     * @param lm 需要删除的日志对象
     */
    @Override
    public void removeLog(LogModel lm) {
        //1：先读取文件的内容
        List<LogModel> list = fileLog.readLogFile();
        //2：删除相应的日志对象
        list.remove(lm);
        //3：重新写入文件
        fileLog.writeLogFile(list);
    }

    /**
     * 获取所有的日志
     *
     * @return 所有的日志对象
     */
    @Override
    public List<LogModel> getAllLog() {
        return fileLog.readLogFile();
    }
}
