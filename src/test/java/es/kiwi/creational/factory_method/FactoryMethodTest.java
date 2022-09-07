package es.kiwi.creational.factory_method;

import es.kiwi.creational.factory_method.extension.parameterized.ExportOperateExtended;
import es.kiwi.creational.factory_method.mosh.ProductsController;
import es.kiwi.creational.factory_method.solution.ExportDBOperate;
import es.kiwi.creational.factory_method.solution.ExportOperate;
import org.junit.Test;

public class FactoryMethodTest {

    /*Defer the creation of an object to subclasses*/
    @Test
    public void mainMosh() {
        ProductsController controller = new ProductsController();
        controller.listProducts();
    }

    /**
     * 使用工厂方法模式来实现示例
     */
    @Test
    public void factoryMethod() {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportDBOperate();

        //调用输出数据的功能方法
        operate.export("测试数据");
    }

    /**
     * 参数化工厂方法
     * <p>
     * 通过给工厂方法传递参数，让工厂方法根据参数的不同来创建不同的产品对象
     */
    @Test
    public void parameterized() {
        //创建需要使用的Creator对象
        es.kiwi.creational.factory_method.extension.parameterized.ExportOperate operate =
                new es.kiwi.creational.factory_method.extension.parameterized.ExportOperate();

        //调用输出数据的功能方法
        operate.export(1, "测试数据");


        //使用参数化工厂方法，扩展起来会非常容易
        es.kiwi.creational.factory_method.extension.parameterized.ExportOperate operate2 = new ExportOperateExtended();
        operate2.export(1, "Test1");
        operate2.export(2, "Test2");
        operate2.export(3, "Test3");
    }
}
