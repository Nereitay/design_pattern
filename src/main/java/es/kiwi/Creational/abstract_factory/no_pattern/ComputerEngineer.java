package es.kiwi.Creational.abstract_factory.no_pattern;

import es.kiwi.Creational.abstract_factory.common.CPUApi;
import es.kiwi.Creational.abstract_factory.common.MainBoardApi;

/**
 * 装机工程师的类
 */
public class ComputerEngineer {
    /**
     * 定义组装机器需要的CPU
     */
    private CPUApi cpu = null;

    /**
     * 定义组装机器需要的主板
     */
    private MainBoardApi mainBoard = null;

    /**
     * 装机过程
     * @param cpuType 客户选择所需的CPU的类型
     * @param mainBoardType 客户选择所需主板的类型
     */
    public void makeComputer(int cpuType, int mainBoardType) {
        //1. 首先准备好装机所需要的配件
        prepareHardware(cpuType, mainBoardType);
        //2. 组装机器
        //3. 测试机器
        //4. 交付客户
    }

    /**
     * 准备装机所需要的配件
     * @param cpuType 客户选择所需的CPU的类型
     * @param mainBoardType 客户选择所需主板的类型
     */
    private void prepareHardware(int cpuType, int mainBoardType) {
        //这里要去准备CPU和主板的具体事项，为了示例简单，这里只准备这两个
        //可是，装机工程师并不知道如何去创建，怎么办呢？

        //直接找相应的工厂获取
        this.cpu = CPUFactory.createCPUApi(cpuType);
        this.mainBoard = MainBoardFactory.createMainBoardApi(mainBoardType);

        //测试一下配件是否好用
        this.cpu.calculate();
        this.mainBoard.installCPU();
    }
}
