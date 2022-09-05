package es.kiwi.creational.builder.pattern;

import es.kiwi.creational.builder.common.ExportDataModel;
import es.kiwi.creational.builder.common.ExportFooterModel;
import es.kiwi.creational.builder.common.ExportHeaderModel;

import java.util.Collection;
import java.util.Map;

/**
 * 实现导出数据到XML文件的生成器对象
 */
public class XmlBuilder implements Builder{
    private static final String LINE_SEPARATOR = System.lineSeparator();
    /**
     * 用来记录构建的文件内容，相当于产品
     */
    private StringBuffer sb = new StringBuffer();

    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        sb.append("<?xml version='1.0' encoding = 'gb2312'?>").append(LINE_SEPARATOR)
                .append("<Report>").append(LINE_SEPARATOR)
                .append("  <Header>").append(LINE_SEPARATOR)
                .append("    <DepId>").append(ehm.getDepId()).append("/DepId").append(LINE_SEPARATOR)
                .append("    <ExportDate>").append(ehm.getExportDate()).append("</ExportDate>").append(LINE_SEPARATOR)
                .append("  </Header>").append(LINE_SEPARATOR);
    }

    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        sb.append("  <Body>").append(LINE_SEPARATOR);
        for (String tb1Name : mapData.keySet()) {
            //先拼接表名称
            sb.append("    <DataList TableName=\"").append(tb1Name).append("\">").append(LINE_SEPARATOR);
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tb1Name)) {
                sb.append("      <Data>").append(LINE_SEPARATOR)
                        .append("        <ProductId>")
                        .append(edm.getProductId()).append("</ProductId>").append(LINE_SEPARATOR)
                        .append("        <Price>")
                        .append(edm.getPrice()).append("</Price>").append(LINE_SEPARATOR)
                        .append("        <Amount>")
                        .append(edm.getAmount()).append("</Amount>").append(LINE_SEPARATOR)
                        .append("      </Data>").append(LINE_SEPARATOR);
            }
            sb.append("    </DataList>").append(LINE_SEPARATOR);
        }
        sb.append("  </Body>").append(LINE_SEPARATOR);
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        sb.append("  <Footer>").append(LINE_SEPARATOR)
                .append("    <ExportUser>").append(efm.getExportUser()).append("</ExportUser>").append(LINE_SEPARATOR)
                .append("  </Footer>").append(LINE_SEPARATOR);

        sb.append("</Report>").append(LINE_SEPARATOR);
    }

    public StringBuffer getResult() {
        return sb;
    }
}
