package es.kiwi.Structural.adapter.extension.twoway;

import es.kiwi.Structural.adapter.scenario.LogDbOperateApi;
import es.kiwi.Structural.adapter.scenario.LogModel;

import java.util.List;

/**
 * DB存储日志的实现，为了简单，这里就不去真正地实现和数据库交互了，示意一下
 */
public class LogDbOperate implements LogDbOperateApi {
    @Override
    public void createLog(LogModel logModel) {
        System.out.println("now in LogDbOperate createLog, lm = " + logModel);
    }

    @Override
    public void updateLog(LogModel logModel) {
        System.out.println("now in LogDbOperate updateLog, lm = " + logModel);

    }

    @Override
    public void removeLog(LogModel logModel) {
        System.out.println("now in LogDbOperate removeLog, lm = " + logModel);

    }

    @Override
    public List<LogModel> getAllLog() {
        System.out.println("now in LogDbOperate getAllLog, lm = ");
        return null;
    }
}
