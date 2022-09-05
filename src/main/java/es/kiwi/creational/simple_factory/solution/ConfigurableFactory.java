package es.kiwi.creational.simple_factory.solution;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工厂类，用来创建api对象
 */
public class ConfigurableFactory {
    /*
    具体创建api方法，根据配置文件的参数来创建接口
     */
    public static Api createApi() {

        //直接读取配置文件来获取需要创建实例的类
        Properties p = new Properties();
        InputStream is = null;

        try {
            is = ConfigurableFactory.class.getResourceAsStream("FactoryTest.properties");
            p.load(is);
        } catch (IOException e) {
            System.out.println("装配工厂配置文件出错了，具体的堆栈信息如下：");
            e.printStackTrace();
        } finally {

            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Api api = null;

        try {
            api = (Api) Class.forName(p.getProperty("ImplClass")).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return api;
    }
}
