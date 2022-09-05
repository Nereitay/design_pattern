package es.kiwi.structural.adapter.extension.twoway;

import es.kiwi.structural.adapter.scenario.LogDbOperateApi;
import es.kiwi.structural.adapter.scenario.LogFileOperateApi;
import es.kiwi.structural.adapter.scenario.LogModel;

import java.util.List;

/**
 * 双向适配器对象，
 *
 * 实现需要适配的两个接口
 */
public class TwoWayAdapter implements LogFileOperateApi, LogDbOperateApi {

    /*持有双向适配的日志接口对象*/
    /**
     * 持有需要被适配的DB存储日志的接口对象
     */
    private LogDbOperateApi dbLog;

    /**
     * 持有需要被适配文件存储日志的接口对象
     */
    private LogFileOperateApi fileLog;

    /**
     * 构造方法，传入需要被适配的对象
     * @param dbLog 需要被适配的DB存储日志的接口对象
     * @param fileLog 需要被适配的文件存储日志的接口对象
     */
    public TwoWayAdapter(LogDbOperateApi dbLog, LogFileOperateApi fileLog) {
        this.dbLog = dbLog;
        this.fileLog = fileLog;
    }

    /*--------------------以下是把文件操作的方式适配成为DB实现方式的接口--------------------------*/

    @Override
    public void createLog(LogModel logModel) {
        //1. 先读取文件内容
        List<LogModel> list = fileLog.readLogFile();
        //2. 加入新的日志对象
        list.add(logModel);
        //3.重新写入文件
        fileLog.writeLogFile(list);
    }

    @Override
    public List<LogModel> getAllLog() {
        return fileLog.readLogFile();
    }

    @Override
    public void removeLog(LogModel logModel) {
        //1. 先读取文件内容
        List<LogModel> list = fileLog.readLogFile();
        //2. 删除相应的日志对象
        list.remove(logModel);
        //3.重新写入文件
        fileLog.writeLogFile(list);
    }

    @Override
    public void updateLog(LogModel logModel) {

        //1. 先读取文件内容
        List<LogModel> list = fileLog.readLogFile();
        //2. 修改相应的日志对象
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogId().equals(logModel.getLogId())) {
                list.set(i, logModel);
                break;
            }
        }
        //3.重新写入文件
        fileLog.writeLogFile(list);
    }

    /*--------------------以下是把DB操作的方式适配成为文件实现方式的接口--------------------------*/

    @Override
    public List<LogModel> readLogFile() {
        return dbLog.getAllLog();
    }

    @Override
    public void writeLogFile(List<LogModel> list) {
        //1. 最简单的实现思路是先删除数据库中的数据
        //2. 然后循环把现在的数据加入到数据库中
        for (LogModel logModel : list) {
            dbLog.createLog(logModel);

        }
    }
}
