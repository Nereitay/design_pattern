package es.kiwi.creational.singleton.scenario;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取应用配置文件
 */
@Getter //只有访问参数的方法，没有设置参数的方法
public class AppConfig {
    /**
     * 用来存放配置文件中参数A的值
     */
    private String parameterA;
    /**
     * 用来存放配置文件中参数B的值
     */
    private String parameterB;

    /**
     * 构造方法
     */
    public AppConfig() {
        //调用读取配置文件的方法
        readConfig();
    }

    /**
     * 读取配置文件，被配置文件中的内容读出来设置到属性上
     */
    private void readConfig() {
        Properties prop = new Properties();
        InputStream is = null;

        try {
            is = AppConfig.class.getClassLoader().getResourceAsStream("AppConfig.properties");
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
