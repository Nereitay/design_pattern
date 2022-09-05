package es.kiwi.structural.proxy;

import es.kiwi.structural.proxy.extension.java_proxy.DynamicProxy;
import es.kiwi.structural.proxy.extension.protection_proxy.Order;
import es.kiwi.structural.proxy.extension.protection_proxy.OrderApi;
import es.kiwi.structural.proxy.extension.protection_proxy.OrderProxy;
import es.kiwi.structural.proxy.scenario.UserManager;
import es.kiwi.structural.proxy.scenario.UserModel;
import es.kiwi.structural.proxy.solution.UserModelApi;

import java.util.Collection;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        /*访问多条数据*/
//        scenario();

        /*使用代理模式来解决问题*/
//        proxy();

        /*
         * 代理的分类：
         *   - 虚代理
         *   - 远程代理
         *   - copy-on-write
         *   - 保护代理
         *   - Cache代理
         *   - 防火墙代理
         *   - 同步代理
         *   - 智能指引
         * */

        /*保护代理：控制对原始对象访问的代理，多用于对象应该由不同访问权限的时候*/
//        protection();

        /*Java动态代理*/
//        javaProxy();

        /*采用对象继承的方式来实现代理*/
//        inheritance();
    }

    private static void inheritance() {
        es.kiwi.structural.proxy.extension.protection_proxy.inherition.Order order =
                new es.kiwi.structural.proxy.extension.protection_proxy.inherition.OrderProxy("设计模式", 100, "张三");

        order.setOrderNum(123, "李四");
        System.out.println("李四修改后订单记录没有变化：" + order);

        order.setOrderNum(123, "张三");
        System.out.println("张三修改后，订单记录：" + order);
    }

    private static void javaProxy() {
        //张三先登录系统创建了一个订单
        Order order = new Order("设计模式", 100, "张三");

        //创建一个动态代理
        DynamicProxy dynamicProxy = new DynamicProxy();
        //然后把订单和动态阿代理关联起来
        OrderApi orderApi = dynamicProxy.getProxyInterface(order);

        //以下就需要使用被代理过的接口来操作了
        //李四想要来修改那就会报错
        orderApi.setOrderNum(123, "李四");
        //输出order
        System.out.println("李四修改后订单记录没有变化：" + orderApi);
        //张三修改就不会有问题
        orderApi.setOrderNum(123, "张三");
        //再次输出order
        System.out.println("张三修改后，订单记录：" + orderApi);
    }

    private static void protection() {
        //张三先登录系统创建一个订单
        OrderProxy order = new OrderProxy(
                new Order("设计模式", 100, "张三"));

        //李四想要来修改没那会被报错
        order.setOrderNum(123, "李四");

        //输出order
        System.out.println("李四修改后订单记录没有变化：" + order);

        //张三修改就不会有问题
        order.setOrderNum(123, "张三");

        //再次输出order
        System.out.println("张三修改后，订单记录：" + order);

    }

    private static void proxy() throws Exception {
        es.kiwi.structural.proxy.solution.UserManager userManager = new es.kiwi.structural.proxy.solution.UserManager();
        List<UserModelApi> list = userManager.getUserByDepId("0101");

        //如果只是显示用户名称，则不需要重新查询数据库
        for (UserModelApi umApi : list) {
            System.out.println("用户编号：= " + umApi.getUserId()
                    + "，用户姓名： = " + umApi.getName());
        }

        //如果访问非用户编号和用户姓名外的属性，那就会重新查询数据库
        for (UserModelApi umApi : list) {
            System.out.println("用户编号：= " + umApi.getUserId()
                    + "，用户姓名： = " + umApi.getName()
                    + "，所属部门：= " + umApi.getDepId());
        }
    }

    private static void scenario() throws Exception {
        UserManager userManager = new UserManager();
        Collection<UserModel> col = userManager.getUserByDepId("0101");
        System.out.println(col);
    }
}
