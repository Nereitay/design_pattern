package es.kiwi.Structural.adapter;

import es.kiwi.Structural.adapter.extension.class_adaptor.ClassAdapter;
import es.kiwi.Structural.adapter.extension.twoway.LogDbOperate;
import es.kiwi.Structural.adapter.extension.twoway.TwoWayAdapter;
import es.kiwi.Structural.adapter.scenario.LogDbOperateApi;
import es.kiwi.Structural.adapter.scenario.LogFileOperate;
import es.kiwi.Structural.adapter.scenario.LogFileOperateApi;
import es.kiwi.Structural.adapter.scenario.LogModel;
import es.kiwi.Structural.adapter.solution.sample.Adapted;
import es.kiwi.Structural.adapter.solution.sample.Adapter;
import es.kiwi.Structural.adapter.solution.sample.Target;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        /*日志管理第一版：以文件形式记录*/
//        log1();

        /*适配器示例*/
//        sample();

        /*使用适配器模式来实现示例, 对象适配器*/
//        adaptor();

        /*双向适配器*/
//        twoWay();

        /*类适配器*/
//        classAdaptor();

    }

    private static void classAdaptor() {
        //准备日志内容也就是测试的数据
        LogModel logModel = new LogModel();
        logModel.setLogId("004");
        logModel.setOperateUser("admin");
        logModel.setOperateTime("2010-03-02 10:08:18");
        logModel.setLogContent("这是一个测试");

        List<LogModel> list = new ArrayList<>();
        list.add(logModel);

        ClassAdapter classAdapter = new ClassAdapter("");
        classAdapter.createLog(logModel);
        List<LogModel> allLog = classAdapter.getAllLog();
        System.out.println("alllog" + allLog);

        classAdapter.writeLogFile(list);
        List<LogModel> logModels = classAdapter.readLogFile();
        System.out.println("logmodels" + logModels);
    }

    private static void twoWay() {
        //准备日志内容也就是测试的数据
        LogModel logModel = new LogModel();
        logModel.setLogId("003");
        logModel.setOperateUser("admin");
        logModel.setOperateTime("2010-03-02 10:08:18");
        logModel.setLogContent("这是一个测试");

        List<LogModel> list = new ArrayList<>();
        list.add(logModel);

        //创建操作日志文件的对象
        LogFileOperateApi fileLogApi = new LogFileOperate("");
        LogDbOperateApi dbLogApi = new LogDbOperate();

        //创建经过双向适配后的操作日志的接口对象
        LogFileOperateApi fileLogApi2 = new TwoWayAdapter(dbLogApi, fileLogApi);
        LogDbOperateApi dbLogApi2 = new TwoWayAdapter(dbLogApi, fileLogApi);

        //先测试从文件操作适配到第二版
        //虽然调用的是第二版接口，其实是文件操作在实现
        dbLogApi2.createLog(logModel);
        List<LogModel> allLog = dbLogApi2.getAllLog();
        System.out.println("alllog" + allLog);

        //再测试从数据库存储适配成第一版接口
        //也就是调用第一版接口，其实是数据实现
        fileLogApi2.writeLogFile(list);
        fileLogApi2.readLogFile();
    }

    private static void adaptor() {
        //准备日志内容也就是测试的数据
        LogModel logModel = new LogModel();
        logModel.setLogId("002");
        logModel.setOperateUser("admin");
        logModel.setOperateTime("2010-03-02 10:08:18");
        logModel.setLogContent("这是一个测试");

        List<LogModel> list = new ArrayList<>();
        list.add(logModel);

        //创建操作日志的对象
        LogFileOperateApi api = new LogFileOperate("");

        //创建新版操作日志的接口对象
        LogDbOperateApi adapter = new es.kiwi.Structural.adapter.solution.Adapter(api);

        //保存日志文件
        adapter.createLog(logModel);

        //读取日志文件的内容
        List<LogModel> allLog = adapter.getAllLog();
        System.out.println("alllog=" + allLog);
    }

    private static void sample() {
        //创建需要被适配的对象
        Adapted adapted = new Adapted();
        //创建客户端需要调用的接口对象
        Target target = new Adapter(adapted);
        //请求处理
        target.request();
    }

    private static void log1() {
        //准备日志内容也就是测试的数据
        LogModel logModel = new LogModel();
        logModel.setLogId("001");
        logModel.setOperateUser("admin");
        logModel.setOperateTime("2010-03-02 10:08:18");
        logModel.setLogContent("这是一个测试");

        List<LogModel> list = new ArrayList<>();
        list.add(logModel);

        //创建操作日志文件的对象
        LogFileOperateApi api = new LogFileOperate("");
        //保存日志文件
        api.writeLogFile(list);

        //读取日志文件的内容
        List<LogModel> readLog = api.readLogFile();
        System.out.println("readLog=" + readLog);
    }
}
