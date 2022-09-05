package es.kiwi.structural.facade.scenario;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置管理，就是负责读取配置文件，并把配置文件的内容设置到ConfigModel中去，是个单例
 */
public class ConfigManager {

    private static ConfigManager manager;
    private static ConfigModel configModel;

    private ConfigManager() {

    }

    public static ConfigManager getInstance() {
        if (manager == null) {
            manager = new ConfigManager();
            configModel = new ConfigModel();
            // 读取配置文件把值设置到configModel中去
            Properties prop = new Properties();
            InputStream is = null;

            try {
                is = ConfigManager.class.getClassLoader().getResourceAsStream("Config.properties");
                prop.load(is);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            configModel.setNeedGenPresentation(Boolean.parseBoolean(prop.getProperty("needGenPresentation")));
            configModel.setNeedGenBusiness(Boolean.parseBoolean(prop.getProperty("needGenBusiness")));
            configModel.setNeedGenDAO(Boolean.parseBoolean(prop.getProperty("needGenDAO")));
        }

        return manager;
    }

    /**
     * 获取配置的数据
     * @return 配置的数据
     */
    public ConfigModel getConfigData() {
        return configModel;
    }
}
