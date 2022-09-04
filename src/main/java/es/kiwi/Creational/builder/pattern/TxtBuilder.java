package es.kiwi.Creational.builder.pattern;

import es.kiwi.Creational.builder.common.ExportDataModel;
import es.kiwi.Creational.builder.common.ExportFooterModel;
import es.kiwi.Creational.builder.common.ExportHeaderModel;

import java.util.Collection;
import java.util.Map;

/**
 * 实现导出数据到文本文件的生成器对象
 */
public class TxtBuilder implements Builder{
    private static final String SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    /**
     * 用来记录构建的文件内容，相当于产品
     */
    private StringBuffer sb = new StringBuffer();

    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        sb.append(ehm.getDepId()).append(SEPARATOR).append(ehm.getExportDate()).append(LINE_SEPARATOR);
    }

    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        for (String tb1Name : mapData.keySet()) {
            //先拼接表名称
            sb.append(tb1Name).append("\n");
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tb1Name)) {
                sb.append(edm.getProductId()).append(SEPARATOR)
                        .append(edm.getPrice()).append(SEPARATOR)
                        .append(edm.getAmount()).append(LINE_SEPARATOR);
            }
        }
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        sb.append(efm.getExportUser());
    }

    public StringBuffer getResult() {
        return sb;
    }
}
