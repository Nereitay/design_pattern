package es.kiwi.creational.builder.example1;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述输出数据的对象
 */
@Getter
@Setter
public class ExportDataModel {
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 销售价格
     */
    private double price;
    /**
     * 销售数量
     */
    private double amount;
}
