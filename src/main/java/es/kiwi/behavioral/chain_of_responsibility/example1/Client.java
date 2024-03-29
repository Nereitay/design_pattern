package es.kiwi.behavioral.chain_of_responsibility.example1;

public class Client {
    public static void main(String[] args) {
        FeeRequest request = new FeeRequest();

        //开始测试
        String ret1 = request.requestToProjectManager("小李", 300);
        System.out.println("the ret1=" + ret1);
        String ret2 = request.requestToProjectManager("小张", 300);
        System.out.println("the ret2=" + ret2);

        String ret3 = request.requestToProjectManager("小李", 600);
        System.out.println("the ret3=" + ret3);
        String ret4 = request.requestToProjectManager("小张", 600);
        System.out.println("the ret4=" + ret4);

        String ret5 = request.requestToProjectManager("小李", 1200);
        System.out.println("the ret5=" + ret5);
        String ret6 = request.requestToProjectManager("小张", 1200);
        System.out.println("the ret6=" + ret6);
    }
}
/*
* 聚餐费用申请的处理流程是可能变动的
* 各个处理环节的业务处理也是会变动的
* 思路：动态构建流程步骤，这样随时都可以重新组合出新的流程来
* */