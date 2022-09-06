package es.kiwi.creational.singleton;

import es.kiwi.creational.singleton.mosh.ConfigManager;
import es.kiwi.creational.singleton.mosh.ConfigManager1;
import es.kiwi.creational.singleton.scenario.AppConfig;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void mainMosh() {
        ConfigManager manager = new ConfigManager();
        manager.set("name", "Brett");

        ConfigManager other = new ConfigManager();
        System.out.println(other.get("name"));

        System.out.println("--------------------Singleton Pattern-------------------");

        ConfigManager1 manager1 = ConfigManager1.getInstance();
        manager1.set("name", "Brett");

        ConfigManager1 other1 = ConfigManager1.getInstance();
        System.out.println(other1.get("name"));
    }

    /**
     * 读取配置文件内容
     */
    @Test
    public void scenario() {
        //创建读取应用配置对象
        AppConfig config = new AppConfig();

        String paramA = config.getParameterA();
        String paramB = config.getParameterB();

        System.out.println("paramA = " + paramA + " paramB = " + paramB);
    }

    /**
     * 使用单例模式重写示例
     * 以饿汉式为例
     */
    @Test
    public void singleton() {
        //创建读取应用配置的对象
        es.kiwi.creational.singleton.solution.AppConfig config =
                es.kiwi.creational.singleton.solution.AppConfig.getInstance();
        es.kiwi.creational.singleton.solution.AppConfig config1 =
                es.kiwi.creational.singleton.solution.AppConfig.getInstance();

        String paramA = config.getParameterA();
        String paramB = config.getParameterB();

        System.out.println("paramA = " + paramA + " paramB = " + paramB);
        System.out.println(config == config1);
    }


}
