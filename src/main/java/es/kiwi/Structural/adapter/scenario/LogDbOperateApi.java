package es.kiwi.Structural.adapter.scenario;

import java.util.List;

/**
 * (第二版数据库存储)定义操作日志的应用接口，为了示例的简单，只是简单地定义了增删改查的方法
 */
public interface LogDbOperateApi {

    /**
     * 新增日志
     * @param logModel 需要新增的日志对象
     */
    void createLog(LogModel logModel);

    /**
     * 修改日志
     * @param logModel 需要修改的日志对象
     */
    void updateLog(LogModel logModel);

    /**
     * 删除日志
     * @param logModel 需要删除的日志对象
     */
    void removeLog(LogModel logModel);

    /**
     * 获取所有日志
     * @return 所有的日志对象
     */
    List<LogModel> getAllLog();

}
