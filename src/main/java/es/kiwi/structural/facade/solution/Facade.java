package es.kiwi.structural.facade.solution;

import es.kiwi.structural.facade.scenario.Business;
import es.kiwi.structural.facade.scenario.DAO;
import es.kiwi.structural.facade.scenario.Presentation;

/**
 * 代码生成子系统的外观对象
 */
public class Facade {
    /*客户端需要的，一个简单的调用代码生成的功能*/
    public void generate() {
        new Presentation().generate();
        new Business().generate();
        new DAO().generate();
    }
}
