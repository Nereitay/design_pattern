package es.kiwi.behavioral.chain_of_responsibility.example4;

public class Client {

    public static void main(String[] args) {
        /*组装链的步骤是不变的，下面的测试也是在同一个职责链上*/
        // 先要组装职责链
        Handler h1 = new GeneralManager();
        Handler h2 = new DepManager();
        Handler h3 = new ProjectManager();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        // 开始测试申请聚餐费用
        String ret1 = h3.handleFeeRequest("小李", 300);
        System.out.println("the ret1=" + ret1);

        String ret2 = h3.handleFeeRequest("小李", 600);
        System.out.println("the ret2=" + ret2);

        String ret3 = h3.handleFeeRequest("小李", 1200);
        System.out.println("the ret3=" + ret3);


        //开始测试申请差旅费用
        h3.handlePreFeeRequest("小张", 3000);
        h3.handlePreFeeRequest("小张", 6000);
        h3.handlePreFeeRequest("小张", 32000);
    }
}

/*问题：只要增加一个业务，就需要修改职责的接口，很不灵活
* 定义一套通用框架 - 用一个通用的请求对象来封装请求传递的参数 - 定义一个通用的调用方法 - 利用通用请求中的业务标记来区分具体业务
* */
