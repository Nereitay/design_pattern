package es.kiwi.creational.abstract_factory;

import es.kiwi.creational.abstract_factory.extension.scalable.Schema3;
import es.kiwi.creational.abstract_factory.mosh.ant.AntWidgetFactory;
import es.kiwi.creational.abstract_factory.mosh.app.ContactForm1;
import es.kiwi.creational.abstract_factory.mosh.material.MaterialWidgetFactory;
import es.kiwi.creational.abstract_factory.scenario.ComputerEngineer;
import es.kiwi.creational.abstract_factory.solution.Schema1;
import es.kiwi.creational.abstract_factory.solution.sample.AbstractFactory;
import es.kiwi.creational.abstract_factory.solution.sample.ConcreteFactory1;
import org.junit.Test;

public class AbstractFactoryTest {

    /*Provide an interface for creating families of related objects*/
    @Test
    public void mainMosh() {
        new ContactForm1().render(new MaterialWidgetFactory());
        new ContactForm1().render(new AntWidgetFactory());
    }

    @Test
    public void scenario() {
        //创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();
        //告诉装机工程师自己选择的配件，让装机工程师组装电脑
        // 问题：CPU对象和主板对象其实是有关系的，是需要相互匹配的
        engineer.makeComputer(1, 2);
    }

    @Test
    public void sample() {
        //创建抽象工厂对象
        AbstractFactory af = new ConcreteFactory1();
        //通过抽象工厂来获取一系列的对象，如产品A和产品B
        af.createProductA();
        af.createProductB();
    }

    /**
     * 使用抽象工厂模式重写示例
     */
    @Test
    public void abstractFactory() {
        //创建装机工程师对象
        es.kiwi.creational.abstract_factory.solution.ComputerEngineer engineer =
                new es.kiwi.creational.abstract_factory.solution.ComputerEngineer();
        //客户选择并创建需要使用的装机方案对象
        es.kiwi.creational.abstract_factory.solution.AbstractFactory schema = new Schema1();
        //告诉装机工程师自己选择的装机方案，让装机工程师组装电脑
        engineer.makeComputer(schema);
    }

    /**
     * 定义可扩展的工厂
     */
    @Test
    public void scalable() {
        es.kiwi.creational.abstract_factory.extension.scalable.ComputerEngineer engineer =
                new es.kiwi.creational.abstract_factory.extension.scalable.ComputerEngineer();
        es.kiwi.creational.abstract_factory.extension.scalable.AbstractFactory schema = new Schema3();
        engineer.makeHardware(schema);
    }
}
