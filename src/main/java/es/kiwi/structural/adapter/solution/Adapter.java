package es.kiwi.structural.adapter.solution;

import es.kiwi.structural.adapter.scenario.LogDbOperateApi;
import es.kiwi.structural.adapter.scenario.LogFileOperateApi;
import es.kiwi.structural.adapter.scenario.LogModel;

import java.util.List;

/**
 * 适配器对象，将记录日志到文件的功能适配成第二版需要的增删改查功能
 */
public class Adapter implements LogDbOperateApi {

    /**
     * 持有需要被适配的接口对象
     */
    private LogFileOperateApi adapted;

    /**
     * 构造方法，传入需要被适配的对象
     * @param adapted 需要被适配的对象
     */
    public Adapter(LogFileOperateApi adapted) {
        this.adapted = adapted;
    }

    @Override
    public void createLog(LogModel logModel) {
        //1. 先读取文件内容
        List<LogModel> list = adapted.readLogFile();
        //2. 加入新的日志对象
        list.add(logModel);
        //3.重新写入文件
        adapted.writeLogFile(list);
    }

    @Override
    public void updateLog(LogModel logModel) {

        //1. 先读取文件内容
        List<LogModel> list = adapted.readLogFile();
        //2. 修改相应的日志对象
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogId().equals(logModel.getLogId())) {
                list.set(i, logModel);
                break;
            }
        }
        //3.重新写入文件
        adapted.writeLogFile(list);
    }

    @Override
    public void removeLog(LogModel logModel) {
        //1. 先读取文件内容
        List<LogModel> list = adapted.readLogFile();
        //2. 删除相应的日志对象
        list.remove(logModel);
        //3.重新写入文件
        adapted.writeLogFile(list);

    }

    @Override
    public List<LogModel> getAllLog() {
        return adapted.readLogFile();
    }
}
