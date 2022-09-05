package es.kiwi.structural.facade;

import es.kiwi.structural.facade.scenario.Business;
import es.kiwi.structural.facade.scenario.DAO;
import es.kiwi.structural.facade.scenario.Presentation;
import es.kiwi.structural.facade.solution.Facade;
import es.kiwi.structural.facade.solution.sample.AModuleImpl;

public class Client {
    public static void main(String[] args) {
        /*代码生成的应用
        * 问题：
        *  客户端为了使用生成代码的功能，需要与生成代码子系统的多个模块交互
        * */
//        scenario();

        /*外观模式示例代码*/
//        sample();

        /*使用Facade模式重写示例*/
//        facade();

        /*有外观，但是可以不使用*/
//        unusedFacade();


    }

    private static void unusedFacade() {
        AModuleImpl a = new AModuleImpl();
        a.testA();
    }

    private static void sample() {
        es.kiwi.structural.facade.solution.sample.Facade.test();
    }

    private static void facade() {
        new Facade().generate();
    }

    private static void scenario() {
        new Presentation().generate();
        new Business().generate();
        new DAO().generate();
    }
}
