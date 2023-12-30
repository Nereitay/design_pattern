package es.kiwi.creational.abstract_factory.example4;

/**
 * 装机方案二：AMD的CPU + 微星的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema2 implements AbstractFactory {

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
        //type为1表示创建CPU，type为2表示创建主板
        if (type == 1) {
            retObj = new AMDCPU(939);
        } else if (type == 2) {
            retObj = new MSIMainboard(939);
        }

        return retObj;
    }
}
