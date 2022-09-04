package es.kiwi.Behavioral.visitor;

import es.kiwi.Behavioral.visitor.extension.composite.Component;
import es.kiwi.Behavioral.visitor.extension.composite.Composite;
import es.kiwi.Behavioral.visitor.extension.composite.Leaf;
import es.kiwi.Behavioral.visitor.extension.composite.PrintNameVisitor;
import es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.PrintStructVisitor;
import es.kiwi.Behavioral.visitor.scenario.Customer;
import es.kiwi.Behavioral.visitor.scenario.EnterpriseCustomer;
import es.kiwi.Behavioral.visitor.scenario.PersonalCustomer;
import es.kiwi.Behavioral.visitor.solution.PreferenceAnalysisVisitor;
import es.kiwi.Behavioral.visitor.solution.ServiceRequestVisitor;
import es.kiwi.Behavioral.visitor.solution.ValueAnalysisVisitor;
import es.kiwi.Behavioral.visitor.solution.sample.*;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        /*场景问题：扩展客户管理的功能*/
//        scenario();

        /*访问者模式示例*/
//        sample();


        /*使用访问者模式*/
//        visitor();

        /*操作组合对象结构*/
//        composite();

        /*遍历元素的方法也可以放到访问者中*/
//        iteratorInVisitor();

    }

    private static void iteratorInVisitor() {
        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Component root =
                new es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Composite("Ropa");
        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Component c1 =
                new es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Composite("Hombre");
        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Component c2 =
                new es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Composite("Mujer");
        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Component l1 =
                new es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Leaf("Camisas");
        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Component l2 =
                new es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Leaf("Cazadoras");
        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Component l3 =
                new es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Leaf("Faldas");
        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Component l4 =
                new es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Leaf("Trajes");

        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(l1);
        c1.addChild(l2);
        c2.addChild(l3);
        c2.addChild(l4);

        es.kiwi.Behavioral.visitor.extension.composite.iterator_visitor.Visitor psVisitor = new PrintStructVisitor();
        root.accept(psVisitor);
    }

    private static void composite() {
        //定义所有组合对象
        Component root = new Composite("Ropa");
        Component c1 = new Composite("Hombre");
        Component c2 = new Composite("Mujer");
        //定义所有的叶子对象
        Component l1 = new Leaf("Camisas");
        Component l2 = new Leaf("Cazadoras");
        Component l3 = new Leaf("Faldas");
        Component l4 = new Leaf("Trajes");
        //按照树的结构来组合组合对象和叶子对象
        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(l1);
        c1.addChild(l2);
        c2.addChild(l3);
        c2.addChild(l4);
        /*
        //创建ObjectStructure
        es.kiwi.Behavioral.visitor.extension.composite.ObjectStructure os =
                new es.kiwi.Behavioral.visitor.extension.composite.ObjectStructure();
        os.setRoot(root);

        //调用ObjectStructure来处理请求功能
        es.kiwi.Behavioral.visitor.extension.composite.Visitor psVisitor = new PrintNameVisitor();
        os.handleRequest(psVisitor);
        */

        /*不需要ObjectStructure的时候
         *   1. 只有一个被访问对象的时候
         *   2. 从客户端的角度看，他访问的其实就是一个对象，
         *      因此可以把ObjectStructure去掉，然后从客户端调用元素的accept方法
         */
        es.kiwi.Behavioral.visitor.extension.composite.Visitor psVisitor = new PrintNameVisitor();
        root.accept(psVisitor);
    }

    private static void visitor() {
        //创建ObjectStructure
        es.kiwi.Behavioral.visitor.solution.ObjectStructure os =
                new es.kiwi.Behavioral.visitor.solution.ObjectStructure();
        //准备些测试数据，创建客户对象，并加入ObjectStructure
        es.kiwi.Behavioral.visitor.solution.Customer cm1 =
                new es.kiwi.Behavioral.visitor.solution.EnterpriseCustomer();
        cm1.setName("ABC集团");
        os.addElement(cm1);

        es.kiwi.Behavioral.visitor.solution.Customer cm2 =
                new es.kiwi.Behavioral.visitor.solution.EnterpriseCustomer();
        cm2.setName("CDE集团");
        os.addElement(cm2);

        es.kiwi.Behavioral.visitor.solution.Customer cm3 =
                new es.kiwi.Behavioral.visitor.solution.PersonalCustomer();
        cm3.setName("Coco");
        os.addElement(cm3);

        //客户提出服务请求，传入服务请求的Visitor
        ServiceRequestVisitor srVisitor = new ServiceRequestVisitor();
        os.handleRequest(srVisitor);

        //要对客户进行偏好分析，传入偏好分析的Visitor
        PreferenceAnalysisVisitor paVisitor = new PreferenceAnalysisVisitor();
        os.handleRequest(paVisitor);

        //要对客户尽心价值分析，传入价值分析的Visitor
        ValueAnalysisVisitor vaVisitor = new ValueAnalysisVisitor();
        os.handleRequest(vaVisitor);
    }

    private static void sample() {
        //创建ObjectStructure
        ObjectStructure os = new ObjectStructure();
        //创建要加入对象结构的元素
        Element eleA = new ConcreteElementA();
        Element eleB = new ConcreteElementB();
        //把元素加入对象结构
        os.addElement(eleA);
        os.addElement(eleB);
        //创建访问者
        Visitor Visitor = new ConcreteVisitor1();
        //调用业务处理的方法
        os.handleRequest(Visitor);
    }

    private static void scenario() {
        //准备些测试数据
        List<Customer> customerList = prepareTestData();
        //循环对客户进行操作
        customerList.forEach(customer -> {
            //进行偏好分析
            customer.preferenceAnalysis();
            //进行价值分析
            customer.valueAnalysis();
        });
    }

    private static List<Customer> prepareTestData() {

        List<Customer> customerList = new ArrayList<>();

        //为了测试方便，准备些数据
        Customer cm1 = new EnterpriseCustomer();
        cm1.setName("ABC集团");
        customerList.add(cm1);

        Customer cm2 = new EnterpriseCustomer();
        cm2.setName("CDE集团");
        customerList.add(cm2);

        Customer cm3 = new PersonalCustomer();
        cm3.setName("Coco");
        customerList.add(cm3);

        return customerList;
    }
}
