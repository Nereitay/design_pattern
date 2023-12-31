package es.kiwi.creational.builder.example3;

import java.util.Collection;
import java.util.Map;

/**
 * 指导者，指导使用构建器的接口来构建输出的文件的对象
 */
public class Director {
    /**
     * 持有当前需要使用的构建器对象
     */
    private Builder builder;

    /**
     * 构造方法，传入构建器对象
     *
     * @param builder 构建器对象
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(ExportHeaderModel ehm, Map<String, Collection<ExportDataModel>> mapData, ExportFooterModel efm) {
        //1：先构建Header
        builder.buildHeader(ehm);
        //2：然后构建Body
        builder.buildBody(mapData);
        //3：然后构建Footer
        builder.buildFooter(efm);
    }
}
