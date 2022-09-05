package es.kiwi.structural.adapter.extension.class_adaptor;

import es.kiwi.structural.adapter.scenario.LogDbOperateApi;
import es.kiwi.structural.adapter.scenario.LogFileOperate;
import es.kiwi.structural.adapter.scenario.LogModel;

import java.util.List;

/**
 * 类适配器对象
 */
public class ClassAdapter extends LogFileOperate implements LogDbOperateApi {
    /**
     * 构造方法，传入文件的路径和名称
     *
     * @param logFilePathName
     */
    public ClassAdapter(String logFilePathName) {
        super(logFilePathName);
    }

    @Override
    public void createLog(LogModel logModel) {
        //1. 先读取文件内容
        List<LogModel> list = this.readLogFile();
        //2. 加入新的日志对象
        list.add(logModel);
        //3.重新写入文件
        this.writeLogFile(list);
    }

    @Override
    public List<LogModel> getAllLog() {
        return this.readLogFile();
    }

    @Override
    public void removeLog(LogModel logModel) {
        //1. 先读取文件内容
        List<LogModel> list = this.readLogFile();
        //2. 删除相应的日志对象
        list.remove(logModel);
        //3.重新写入文件
        this.writeLogFile(list);

    }

    @Override
    public void updateLog(LogModel logModel) {

        //1. 先读取文件内容
        List<LogModel> list = this.readLogFile();
        //2. 修改相应的日志对象
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogId().equals(logModel.getLogId())) {
                list.set(i, logModel);
                break;
            }
        }
        //3.重新写入文件
        this.writeLogFile(list);
    }
}
