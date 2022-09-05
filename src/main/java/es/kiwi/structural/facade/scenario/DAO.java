package es.kiwi.structural.facade.scenario;

/**
 * 示意生成数据层模块
 */
public class DAO {
    public void generate() {

        ConfigModel configModel
                = ConfigManager.getInstance().getConfigData();
        if (configModel.isNeedGenDAO()) {


            System.out.println("正在生成数据层代码文件");
        }
    }
}
