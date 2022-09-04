package es.kiwi.Behavioral.chain_of_responsibility;

import es.kiwi.Behavioral.chain_of_responsibility.extension.chain_of_functions.GoodsSaleEbo;
import es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.StaffBanquetRequestModel;
import es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame_extended.DepManager2;
import es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame_extended.GeneralManager2;
import es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame_extended.PrepaidTravelExpensesRequestModel;
import es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame_extended.ProjectManager2;
import es.kiwi.Behavioral.chain_of_responsibility.scenario.SaleModel;
import es.kiwi.Behavioral.chain_of_responsibility.scenario.StaffBanquetRequest;
import es.kiwi.Behavioral.chain_of_responsibility.solution.DepManager;
import es.kiwi.Behavioral.chain_of_responsibility.solution.GeneralManager;
import es.kiwi.Behavioral.chain_of_responsibility.solution.ProjectManager;
import es.kiwi.Behavioral.chain_of_responsibility.solution.sample.ConcreteHandler1;
import es.kiwi.Behavioral.chain_of_responsibility.solution.sample.ConcreteHandler2;
import es.kiwi.Behavioral.chain_of_responsibility.solution.sample.Handler;

public class Client {

    public static void main(String[] args) {
        /*不使用职责链模式*/
//        scenario();

        /*职责链模式示例代码*/
//        sample();

        /*使用职责链模式*/
//        chain();

        /*处理多种请求*/
//        multiRequests();

        /*处理多种请求通用框架*/
//        multiRequestFrame();

        /*处理多种请求通用框架 -> 扩展新的业务*/
//        multiRequestFrameExtended();

        /*功能链*/
//        chainOfFunctions();

    }

    private static void chainOfFunctions() {
        //创建业务对象
        GoodsSaleEbo ebo = new GoodsSaleEbo();

        //准备测试数据
        SaleModel saleModel = new SaleModel();
        saleModel.setGoods("张学友怀旧经典");
        saleModel.setSaleNum(10);

        //调用业务功能
        ebo.sale("Uva", "Piña", saleModel);
        ebo.sale("Caqui", "Manzana", saleModel);
    }

    private static void multiRequestFrameExtended() {
        //先要组装职责链
        /*
         * 注意这里创建的都是扩展后的对象，可以同时支持两种业务
         */
        es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.Handler h1 = new GeneralManager2();
        es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.Handler h2 = new DepManager2();
        es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.Handler h3 = new ProjectManager2();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试申请聚餐费用
        StaffBanquetRequestModel frm = new StaffBanquetRequestModel();
        frm.setFee(300);
        frm.setUser("Uva");
        //调用处理
        String ret1 = (String) h3.handleRequest(frm);
        System.out.println("the ret1 = " + ret1);

        //重新设置申请金额，再调用处理
        frm.setFee(800);
        String ret2 = (String) h3.handleRequest(frm);
        System.out.println("the ret2 = " + ret2);

        //重新设置申请金额，再调用处理
        frm.setFee(1600);
        String ret3 = (String) h3.handleRequest(frm);
        System.out.println("the ret3 = " + ret3);

        //开始测试申请预支差旅费用
        PrepaidTravelExpensesRequestModel prm = new PrepaidTravelExpensesRequestModel();
        prm.setFee(3000);
        prm.setUser("Uva");
        //调用处理
        h3.handleRequest(prm);
        //重新设置申请金额，再调用处理
        prm.setFee(6000);
        h3.handleRequest(prm);
        //重新设置申请金额，再调用处理
        prm.setFee(36000);
        h3.handleRequest(prm);
    }

    private static void multiRequestFrame() {
        //先要组装职责链
        es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.Handler h1 =
                new es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.GeneralManager();
        es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.Handler h2 =
                new es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.DepManager();
        es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.Handler h3 =
                new es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.ProjectManager();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试申请聚餐费用
        StaffBanquetRequestModel frm = new StaffBanquetRequestModel();
        frm.setFee(300);
        frm.setUser("Uva");
        //调用处理
        String ret1 = (String) h3.handleRequest(frm);
        System.out.println("the ret1 = " + ret1);

        //重新设置申请金额，再调用处理
        frm.setFee(800);
        String ret2 = (String) h3.handleRequest(frm);
        System.out.println("the ret2 = " + ret2);

        //重新设置申请金额，再调用处理
        frm.setFee(1600);
        String ret3 = (String) h3.handleRequest(frm);
        System.out.println("the ret3 = " + ret3);
    }

    private static void multiRequests() {
        //先要组装职责链
        es.kiwi.Behavioral.chain_of_responsibility.solution.Handler h1 = new GeneralManager();
        es.kiwi.Behavioral.chain_of_responsibility.solution.Handler h2 = new DepManager();
        es.kiwi.Behavioral.chain_of_responsibility.solution.Handler h3 = new ProjectManager();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试申请聚餐费用
        String ret1 = h3.handleStaffBanquetRequest("Uva", 300);
        System.out.println("the ret1 = " + ret1);
        String ret2 = h3.handleStaffBanquetRequest("Uva", 600);
        System.out.println("the ret2 = " + ret2);
        String ret3 = h3.handleStaffBanquetRequest("Uva", 1200);
        System.out.println("the ret3 = " + ret3);

        //开始测试申请预支差旅费用
        h3.handlePrepaidTravelExpensesRequest("Uva", 3000);
        h3.handlePrepaidTravelExpensesRequest("Uva", 6000);
        h3.handlePrepaidTravelExpensesRequest("Uva", 32000);
    }

    private static void chain() {
        //先要组装职责链
        es.kiwi.Behavioral.chain_of_responsibility.solution.Handler h1 = new GeneralManager();
        es.kiwi.Behavioral.chain_of_responsibility.solution.Handler h2 = new DepManager();
        es.kiwi.Behavioral.chain_of_responsibility.solution.Handler h3 = new ProjectManager();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试
        String ret1 = h3.handleStaffBanquetRequest("Uva", 300);
        System.out.println("the ret1 = " + ret1);
        String ret2 = h3.handleStaffBanquetRequest("Caqui", 300);
        System.out.println("the ret2 = " + ret2);

        String ret3 = h3.handleStaffBanquetRequest("Uva", 600);
        System.out.println("the ret3 = " + ret3);
        String ret4 = h3.handleStaffBanquetRequest("Caqui", 600);
        System.out.println("the ret4 = " + ret4);

        String ret5 = h3.handleStaffBanquetRequest("Uva", 1200);
        System.out.println("the ret5 = " + ret5);
        String ret6 = h3.handleStaffBanquetRequest("Caqui", 1200);
        System.out.println("the ret6 = " + ret6);
    }

    private static void sample() {
        //先要组装职责链
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();

        h1.setSuccessor(h2);

        //然后提交请求
        h1.handleRequest();
    }

    private static void scenario() {
        StaffBanquetRequest request = new StaffBanquetRequest();

        //开始测试
        String ret1 = request.requestToProjectManager("Uva", 300);
        System.out.println("the ret1 = " + ret1);
        String ret2 = request.requestToProjectManager("Caqui", 300);
        System.out.println("the ret2 = " + ret2);

        String ret3 = request.requestToProjectManager("Uva", 600);
        System.out.println("the ret3 = " + ret3);
        String ret4 = request.requestToProjectManager("Caqui", 600);
        System.out.println("the ret4 = " + ret4);

        String ret5 = request.requestToProjectManager("Uva", 1200);
        System.out.println("the ret5 = " + ret5);
        String ret6 = request.requestToProjectManager("Caqui", 1200);
        System.out.println("the ret6 = " + ret6);
    }
}
