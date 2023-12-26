package es.kiwi.structural.adapter.example1;

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
        LogFileOperateApi api = new LogFileOperate("");
        //保存日志文件
        api.writeLogFile(list);

        //读取日志文件的内容
        List<LogModel> readLog = api.readLogFile();
        System.out.println("readLog = " + readLog);
    }
}
/*
* 客户要求：能不能让日志管理第二版实现同时支持数据库存储和文件存储两种方式？
* 问题：接口不兼容
* */
