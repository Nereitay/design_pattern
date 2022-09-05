package es.kiwi.creational.builder.no_pattern;


import es.kiwi.creational.builder.common.ExportDataModel;
import es.kiwi.creational.builder.common.ExportFooterModel;
import es.kiwi.creational.builder.common.ExportHeaderModel;

import java.util.Collection;
import java.util.Map;

/**
 * 导出数据到Xml文件的对象
 */
public class ExportToXml {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 导出数据到XML文件
     *
     * @param ehm     文件头的内容
     * @param mapData 数据的内容
     * @param efm     文件尾的内容
     */
    public void export(ExportHeaderModel ehm,
                       Map<String, Collection<ExportDataModel>> mapData,
                       ExportFooterModel efm) {
        //用来记录最终输出的文件内容
        StringBuffer sb = new StringBuffer();
        //1. 先来拼接文件头内容
        sb.append("<?xml version='1.0' encoding = 'gb2312'?>").append(LINE_SEPARATOR)
                .append("<Report>").append(LINE_SEPARATOR)
                .append("  <Header>").append(LINE_SEPARATOR)
                .append("    <DepId>").append(ehm.getDepId()).append("/DepId").append(LINE_SEPARATOR)
                .append("    <ExportDate>").append(ehm.getExportDate()).append("</ExportDate>").append(LINE_SEPARATOR)
                .append("  </Header>").append(LINE_SEPARATOR);
        //2. 接着来拼接文件体的内容
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
        //3. 接着来拼接文件尾的内容
        sb.append("  <Footer>").append(LINE_SEPARATOR)
                .append("    <ExportUser>").append(efm.getExportUser()).append("</ExportUser>").append(LINE_SEPARATOR)
                .append("  </Footer>").append(LINE_SEPARATOR);

        sb.append("</Report>").append(LINE_SEPARATOR);
        //为了演示的简洁性，这里就不再写输出文件的代码了
        //把要输出的内容输出到控制台看看
        System.out.println("输出到XML文件的内容：\n" + sb);

    }
}
