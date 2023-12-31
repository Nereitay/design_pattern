package es.kiwi.creational.builder.example3;

import java.util.Collection;
import java.util.Map;

/**
 * 实现导出数据到XML文件的的构建器对象
 */
public class XmlBuilder implements Builder{
    /**
     * 用来记录构建的文件的内容，相当于产品
     */
    private StringBuilder sb = new StringBuilder();

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public StringBuilder getResult() {
        return sb;
    }


    /**
     * 构建输出文件的Header部分
     *
     * @param ehm 文件头的内容
     */
    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        sb.append("<?xml version='1.0' encoding='gb2312'?>").append(LINE_SEPARATOR);
        sb.append("<Report>").append(LINE_SEPARATOR);
        sb.append("  <Header>").append(LINE_SEPARATOR);
        sb.append("    <DepId>").append(ehm.getDepId()).append("</DepId>").append(LINE_SEPARATOR);
        sb.append("    <ExportDate>").append(ehm.getExportDate()).append("</ExportDate>").append(LINE_SEPARATOR);
        sb.append("  </Header>").append(LINE_SEPARATOR);
    }

    /**
     * 构建输出文件的Body部分
     *
     * @param mapData 要输出的数据的内容
     */
    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        sb.append("  <Body>").append(LINE_SEPARATOR);
        for (String tblName : mapData.keySet()) {
            //先拼接表名称
            sb.append("    <Datas TableName=\"").append(tblName).append("\">").append(LINE_SEPARATOR);
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tblName)) {
                sb.append("      <Data>").append(LINE_SEPARATOR);
                sb.append("        <ProductId>").append(edm.getProductId()).append("</ProductId>").append(LINE_SEPARATOR);
                sb.append("        <Price>").append(edm.getPrice()).append("</Price>").append(LINE_SEPARATOR);
                sb.append("        <Amount>").append(edm.getAmount()).append("</Amount>").append(LINE_SEPARATOR);
                sb.append("      </Data>").append(LINE_SEPARATOR);
            }
            sb.append("    </Datas>").append(LINE_SEPARATOR);
        }
        sb.append("  </Body>").append(LINE_SEPARATOR);
    }

    /**
     * 构建输出文件的Footer部分
     *
     * @param efm 文件尾的内容
     */
    @Override
    public void buildFooter(ExportFooterModel efm) {
        sb.append("  <Footer>").append(LINE_SEPARATOR);
        sb.append("    <ExportUser>").append(efm.getExportUser()).append("</ExportUser>").append(LINE_SEPARATOR);
        sb.append("  </Footer>").append(LINE_SEPARATOR);
        sb.append("</Report>").append(LINE_SEPARATOR);
    }
}
