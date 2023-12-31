package es.kiwi.creational.builder.example3;

import java.util.Collection;
import java.util.Map;

/**
 * 实现导出数据到文本文件的的构建器对象
 */
public class TxtBuilder implements Builder {
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
        sb.append(ehm.getDepId()).append(",").append(ehm.getExportDate()).append(LINE_SEPARATOR);
    }

    /**
     * 构建输出文件的Body部分
     *
     * @param mapData 要输出的数据的内容
     */
    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        for (String tblName : mapData.keySet()) {
            //先拼接表名称
            sb.append(tblName).append(LINE_SEPARATOR);
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tblName)) {
                sb.append(edm.getProductId()).append(",").append(edm.getPrice()).append(",").append(edm.getAmount()).append(LINE_SEPARATOR);
            }
        }
    }

    /**
     * 构建输出文件的Footer部分
     *
     * @param efm 文件尾的内容
     */
    @Override
    public void buildFooter(ExportFooterModel efm) {
        sb.append(efm.getExportUser());
    }
}
