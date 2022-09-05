package es.kiwi.creational.prototype;

import es.kiwi.creational.prototype.extension.deep_clone.Product;
import es.kiwi.creational.prototype.extension.prototype_manager.ConcretePrototype1;
import es.kiwi.creational.prototype.extension.prototype_manager.ConcretePrototype2;
import es.kiwi.creational.prototype.extension.prototype_manager.Prototype;
import es.kiwi.creational.prototype.extension.prototype_manager.PrototypeManager;
import es.kiwi.creational.prototype.scenario.OrderBusiness;
import es.kiwi.creational.prototype.scenario.PersonalOrder;
import es.kiwi.creational.prototype.solution.OrderApi;

public class Client {
    public static void main(String[] args) {
        /*订单处理系统*/
//        scenario();

        /*使用原型模式重写示例*/
//        prototype();

        /*原型实例和克隆出来的实例是完全独立的，也就是他们指向不同的内存空间java*/
//        differentInstances();

        /*Java中的克隆方法*/
//        javaClone();

        /*自己实现深度克隆*/
//        deepCloneManual();

        /*Java中的深度克隆*/
//        deepCloneJava();

        /*原型管理器*/
//        prototypeManager();

    }

    private static void prototypeManager() {
        try {
            //初始化原型管理器
            Prototype p1 = new ConcretePrototype1();
            PrototypeManager.setPrototype("Prototype1", p1);

            //获取原型来创建对象
            Prototype p3 = PrototypeManager.getPrototype("Prototype1").clone();
            p3.setName("Brett");
            System.out.println("第一个实例：" + p3);

            //有人动态的切换了实现
            Prototype p2 = new ConcretePrototype2();
            PrototypeManager.setPrototype("Prototype1", p2);

            //重新获取原型来创建对象
            Prototype p4 = PrototypeManager.getPrototype("Prototype1").clone();
            p4.setName("Leon");
            System.out.println("第二个实例：" + p4);

            //有人注销了这个原型
            PrototypeManager.removePrototype("Prototype1");

            //再次获取原型来创建对象
            Prototype p5 = PrototypeManager.getPrototype("Prototype1").clone();
            p5.setName("Annie");
            System.out.println("第三个实例：" + p5);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }

    private static void deepCloneJava() {
        //先创建原型实例
        es.kiwi.creational.prototype.extension.deep_clone.java_clone.PersonalOrder oa1 =
                new es.kiwi.creational.prototype.extension.deep_clone.java_clone.PersonalOrder();
        //设置原型实例的值
        es.kiwi.creational.prototype.extension.deep_clone.java_clone.Product product =
                new es.kiwi.creational.prototype.extension.deep_clone.java_clone.Product();
        product.setName("产品1");
        oa1.setProduct(product);
        oa1.setOrderProductNum(100);

        System.out.println("这是第一次获取的对象实例 = " + oa1);

        //通过克隆来获取新的实例
        es.kiwi.creational.prototype.extension.deep_clone.java_clone.PersonalOrder oa2 =
                (es.kiwi.creational.prototype.extension.deep_clone.java_clone.PersonalOrder) oa1.clone();
        //修改它的值
        oa2.getProduct().setName("产品2");
        oa2.setOrderProductNum(80);
        //输出克隆出来的对象的值
        System.out.println("输出克隆出来的实例 = " + oa2);

        //再次输出原型实例的值
        System.out.println("再次输出原型实例 = " + oa1);
    }

    private static void deepCloneManual() {
        //先创建原型实例
        es.kiwi.creational.prototype.extension.deep_clone.PersonalOrder oa1 =
                new es.kiwi.creational.prototype.extension.deep_clone.PersonalOrder();
        //设置原型实例的值
        Product product = new Product();
        product.setName("产品1");
        oa1.setProduct(product);
        oa1.setOrderProductNum(100);

        System.out.println("这是第一次获取的对象实例 = " + oa1);

        //通过克隆来获取新的实例
        es.kiwi.creational.prototype.extension.deep_clone.PersonalOrder oa2 =
                (es.kiwi.creational.prototype.extension.deep_clone.PersonalOrder) oa1.cloneOrder();
        //修改它的值
        oa2.getProduct().setName("产品2");
        oa2.setOrderProductNum(80);
        //输出克隆出来的对象的值
        System.out.println("输出克隆出来的实例 = " + oa2);

        //再次输出原型实例的值
        System.out.println("再次输出原型实例 = " + oa1);
    }

    private static void javaClone() {
        //先创建原型实例
        es.kiwi.creational.prototype.extension.java_clone.PersonalOrder oa1 =
                new es.kiwi.creational.prototype.extension.java_clone.PersonalOrder();
        //设置原型实例订单数量值
        oa1.setOrderProductNum(100);
        //为了简单，这里仅仅输出数量
        System.out.println("这是第一次获取对象实例 === " + oa1.getOrderProductNum());

        //通过克隆来获取新的实例
        es.kiwi.creational.prototype.extension.java_clone.PersonalOrder oa2 =
                (es.kiwi.creational.prototype.extension.java_clone.PersonalOrder) oa1.clone();
        //修改他的数量
        oa2.setOrderProductNum(80);
        //输出克隆对象的值
        System.out.println("输出克隆出来的实例 === " + oa2.getOrderProductNum());

        //再次输出原型实例的值
        System.out.println("再次输出原型实例 === " + oa1.getOrderProductNum());
    }

    private static void differentInstances() {
        //先创建原型实例
        es.kiwi.creational.prototype.solution.OrderApi oa1 =
                new es.kiwi.creational.prototype.solution.PersonalOrder();

        //设置原型实例订单数量值
        oa1.setOrderProductNum(100);
        //为了简单，这里仅仅输出数量
        System.out.println("这是第一次获取对象实例 === " + oa1.getOrderProductNum());

        //通过克隆来获取新的实例
        OrderApi oa2 = oa1.cloneOrder();
        //修改他的数量
        oa2.setOrderProductNum(80);
        //输出克隆对象的值
        System.out.println("输出克隆出来的实例 === " + oa2.getOrderProductNum());

        //再次输出原型实例的值
        System.out.println("再次输出原型实例 === " + oa1.getOrderProductNum());
    }

    private static void prototype() {
        es.kiwi.creational.prototype.solution.PersonalOrder op =
                new es.kiwi.creational.prototype.solution.PersonalOrder();
        op.setOrderProductNum(2925);
        op.setCustomerName("Lucy");
        op.setProductId("P0001");
        es.kiwi.creational.prototype.solution.OrderBusiness ob =
                new es.kiwi.creational.prototype.solution.OrderBusiness();
        ob.saveOrder(op);
    }

    private static void scenario() {
        //创建订单对象，这里为了演示简单，直接new了
        PersonalOrder op = new PersonalOrder();
        //设置订单数据
        op.setOrderProductNum(2925);
        op.setCustomerName("Lucy");
        op.setProductId("P0001");

        //这里获取业务处理的类，也直接new了，为了简单，连业务接口都没有做
        OrderBusiness ob = new OrderBusiness();
        //调用业务来保存订单对象
        ob.saveOrder(op);
    }
}
