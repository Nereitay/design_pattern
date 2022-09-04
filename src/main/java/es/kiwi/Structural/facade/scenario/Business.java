package es.kiwi.Structural.facade.scenario;

/**
 * 示意生成逻辑层模块
 */
public class Business {
    public void generate() {

        ConfigModel configModel
                = ConfigManager.getInstance().getConfigData();
        if (configModel.isNeedGenBusiness()) {

            System.out.println("正在生成逻辑层代码文件");
        }
    }
}
