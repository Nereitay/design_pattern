package es.kiwi.structural.facade.scenario;

/**
 * 示意生成表现层模块
 */
public class Presentation {
    public void generate() {
        //1. 从配置文件中获取相应的配置信息
        ConfigModel configModel
                = ConfigManager.getInstance().getConfigData();
        if (configModel.isNeedGenPresentation()) {

            //2. 按照要求去生成相应的代码，并保存成文件
            System.out.println("正在生成表现层代码文件");
        }
    }
}
