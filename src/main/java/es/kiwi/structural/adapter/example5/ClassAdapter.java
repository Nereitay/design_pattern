package es.kiwi.structural.adapter.example5;

import java.util.List;

/**
 * <p>Java中类似实现类适配器的例子</p>
 * 类适配器对象
 */
public class ClassAdapter extends LogFileOperate implements LogDbOperateApi {
    /**
     * 🦉构造方法，传入文件的路径和名称
     *
     * @param logFilePathName 文件的路径和名称
     */
    public ClassAdapter(String logFilePathName) {
        super(logFilePathName);
    }

    /**
     * 新增日志
     *
     * @param lm 需要新增的日志对象
     */
    @Override
    public void createLog(LogModel lm) {
        //1：先读取文件的内容
        List<LogModel> list = this.readLogFile();
        //2：加入新的日志对象
        list.add(lm);
        //3：重新写入文件
        this.writeLogFile(list);
    }

    /**
     * 修改日志
     *
     * @param lm 需要修改的日志对象
     */
    @Override
    public void updateLog(LogModel lm) {
        //1：先读取文件的内容
        List<LogModel> list = this.readLogFile();
        //2：修改相应的日志对象
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogId().equals(lm.getLogId())) {
                list.set(i, lm);
                break;
            }
        }
        //3：重新写入文件
        this.writeLogFile(list);
    }

    /**
     * 删除日志
     *
     * @param lm 需要删除的日志对象
     */
    @Override
    public void removeLog(LogModel lm) {
        //1：先读取文件的内容
        List<LogModel> list = this.readLogFile();
        //2：删除相应的日志对象
        list.remove(lm);
        //3：重新写入文件
        this.writeLogFile(list);
    }

    /**
     * 获取所有的日志
     *
     * @return 所有的日志对象
     */
    @Override
    public List<LogModel> getAllLog() {
        return this.readLogFile();
    }
}
