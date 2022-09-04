package es.kiwi.Creational.singleton.problem.refactor;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取应用配置文件，单例实现（饿汉式）
 */
@Getter
public class AppConfig {
    /**
     * 定义一个变量来存储创建好的类实例，直接在这里创建类实例，只能创建一次
     *
     */
    private static AppConfig instance = new AppConfig();
    /**
     * 用来存放配置文件中参数A的值
     */
    private String parameterA;
    /**
     * 用来存放配置文件中参数B的值
     */
    private String parameterB;
    /**
     * 私有化构造方法
     */
    private AppConfig() {
        //调用读取配置文件的方法
        readConfig();
    }

    /**
     * 定义一个方法来为客户端提供AppConfig类的实例
     *
     * @return 一个AppConfig实例
     */
    public static AppConfig getInstance() {
        return instance;
    }

    /**
     * 读取配置文件，被配置文件中的内容读出来设置到属性上
     */
    private void readConfig() {
        Properties prop = new Properties();
        InputStream is = null;

        try {
            is = es.kiwi.Creational.singleton.problem.before.AppConfig.class.getResourceAsStream("AppConfig.properties");
            prop.load(is);
            //把配置文件中的内容读出来设置到属性上
            this.parameterA = prop.getProperty("paramA");
            this.parameterB = prop.getProperty("paramB");
        } catch (IOException e) {
            System.out.println("装载配置文件出错了，具体堆栈信息如下：");
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
