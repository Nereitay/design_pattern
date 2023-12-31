package es.kiwi.creational.builder.example2;
/**
 * <p>生成器模式示例代码</p>
 * 构建器接口，定义创建一个产品对象所需的各个部件的操作
 */
public interface Builder {
    /**
     * 示意方法，构建某个部件
     */
    void buildPart();
}
