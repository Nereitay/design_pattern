package es.kiwi.structural.adapter.example4;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        //准备日志内容，也就是测试的数据
        LogModel lm1 = new LogModel();
        lm1.setLogId("001");
        lm1.setOperateUser("admin");
        lm1.setOperateTime("2010-03-02 10:08:18");
        lm1.setLogContent("This is a test.");

        List<LogModel> list = new ArrayList<>();
        list.add(lm1);
        // 创建操作日志文件的对象
        LogFileOperateApi fileLogApi = new LogFileOperate("");
        LogDbOperateApi dbLogApi = new LogDbOperate();

        //🌝创建经过双向适配后的操作日志的接口对象
        LogFileOperateApi fileLogApi2 = new TwoDirectionAdapter(fileLogApi, dbLogApi);
        LogDbOperateApi dblogApi2 = new TwoDirectionAdapter(fileLogApi, dbLogApi);

        //先测试从文件操作适配到第二版，虽然调用的是第二版的接口，其实是文件操作在实现
        dblogApi2.createLog(lm1);
        List<LogModel> allLog = dblogApi2.getAllLog();
        System.out.println("allLog = " + allLog);

        //再测试从数据库存储适配成第一版的接口，也就是调用第一版的接口，其实是数据实现
        fileLogApi2.writeLogFile(list);
        fileLogApi2.readLogFile();

    }
}
