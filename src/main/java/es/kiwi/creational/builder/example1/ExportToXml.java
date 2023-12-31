package es.kiwi.creational.builder.example1;

import java.util.Collection;
import java.util.Map;

/**
 * 导出数据到XML文件的对象
 */
public class ExportToXml {
    /**
     * 导出数据到XML文件
     *
     * @param ehm     文件头的内容
     * @param mapData 数据的内容
     * @param efm     文件尾的内容
     */
    public void export(ExportHeaderModel ehm, Map<String, Collection<ExportDataModel>> mapData, ExportFooterModel efm) {
        String lineSeparator = System.lineSeparator();
        //用来记录最终输出的文件内容
        StringBuilder sb = new StringBuilder();
        //1：先来拼接文件头的内容
        sb.append("<?xml version='1.0' encoding='gb2312'?>").append(lineSeparator);
        sb.append("<Report>").append(lineSeparator);
        sb.append("  <Header>").append(lineSeparator);
        sb.append("    <DepId>").append(ehm.getDepId()).append("</DepId>").append(lineSeparator);
        sb.append("    <ExportDate>").append(ehm.getExportDate()).append("</ExportDate>").append(lineSeparator);
        sb.append("  </Header>").append(lineSeparator);
        //2：接着来拼接文件体的内容
        sb.append("  <Body>").append(lineSeparator);
        for (String tblName : mapData.keySet()) {
            //先拼接表名称
            sb.append("    <Datas TableName=\"").append(tblName).append("\">").append(lineSeparator);
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tblName)) {
                sb.append("      <Data>").append(lineSeparator);
                sb.append("        <ProductId>").append(edm.getProductId()).append("</ProductId>").append(lineSeparator);
                sb.append("        <Price>").append(edm.getPrice()).append("</Price>").append(lineSeparator);
                sb.append("        <Amount>").append(edm.getAmount()).append("</Amount>").append(lineSeparator);
                sb.append("      </Data>").append(lineSeparator);
            }
            sb.append("    </Datas>").append(lineSeparator);
        }
        sb.append("  </Body>").append(lineSeparator);
        //3：接着来拼接文件尾的内容
        sb.append("  <Footer>").append(lineSeparator);
        sb.append("    <ExportUser>").append(efm.getExportUser()).append("</ExportUser>").append(lineSeparator);
        sb.append("  </Footer>").append(lineSeparator);
        sb.append("</Report>").append(lineSeparator);

        //为了演示简洁性，这里就不去写输出文件的代码了
        //把要输出的内容输出到控制台看看
        System.out.println("输出到XML文件的内容：" + lineSeparator + sb);
    }
}
