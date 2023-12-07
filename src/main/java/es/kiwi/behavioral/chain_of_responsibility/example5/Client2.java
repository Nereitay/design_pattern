package es.kiwi.behavioral.chain_of_responsibility.example5;

public class Client2 {
    public static void main(String[] args) {
        /*注意：这里创建的都是扩展过后的对象，可以同时支持两种业务*/
        //先要组装职责链
        Handler h1 = new GeneralManager2();
        Handler h2 = new DepManager2();
        Handler h3 = new ProjectManager2();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试申请聚餐费用
        FeeRequestModel frm = new FeeRequestModel();
        frm.setFee(300);
        frm.setUser("小李");
        //调用处理
        String ret1 = (String) h3.handleRequest(frm);
        System.out.println("ret1=" + ret1);

        //重新设置申请金额，再调用处理
        frm.setFee(800);
        String ret2 = (String) h3.handleRequest(frm);
        System.out.println("ret2=" + ret2);

        //重新设置申请金额，再调用处理
        frm.setFee(1600);
        String ret3 = (String) h3.handleRequest(frm);
        System.out.println("ret3=" + ret3);

        /*注意这里测试不同的业务，但调用处理请求的方法是一样的，是通用的方法*/
        //开始测试申请预支差旅费用
        PreFeeRequestModel pfrm = new PreFeeRequestModel();
        pfrm.setFee(3000);
        pfrm.setUser("小张");
        //调用处理
        h3.handleRequest(pfrm);
        //重新设置申请金额，再调用处理
        pfrm.setFee(6000);
        h3.handleRequest(pfrm);
        //重新设置申请金额，再调用处理
        pfrm.setFee(36000);
        h3.handleRequest(pfrm);
    }
}
/*
* 好处：既通用又灵活 有了新的业务，只需要添加实现新功能的对象就可以了
* 缺陷：可能会造成对象层次过多，或者出现较多的细粒度对象
* */
