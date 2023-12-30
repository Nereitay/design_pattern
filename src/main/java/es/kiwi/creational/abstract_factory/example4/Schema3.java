package es.kiwi.creational.abstract_factory.example4;

/**
 * 装机方案三：Intel 的CPU + 技嘉的主板 + 现代的内存
 */
public class Schema3 implements AbstractFactory {
    /**
     * 一个通用的创建产品对象的方法，为了简单，直接返回Object
     * 也可以为所有被创建的产品定义一个公共的接口
     *
     * @param type 具体创建的产品类型标识
     * @return 创建出的产品对象
     */
    @Override
    public Object createProduct(int type) {
        Object retObj = null;
        //type为1表示创建CPU，type为2表示创建主板，type为3表示创建内存
        if (type == 1) {
            retObj = new IntelCPU(1156);
        } else if (type == 2) {
            retObj = new GAMainboard(1156);
        } else if (type == 3) { //🧠创建新添加的产品
            retObj = new HyMemory();
        }

        return retObj;
    }
}
