package es.kiwi.creational.simple_factory.problem.refactor;

import es.kiwi.creational.simple_factory.problem.common.Api;

/**
 * 客户端：测试Api接口
 */
public class Client {

    public static void main(String[] args) {
        //重要改变，没有new Impl()了，取而代之Factory.createApi()
        Api api = Factory.createApi();
        api.test1("It's just a test");
    }
}
