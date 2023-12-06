package es.kiwi.structural.decorator.example6;

import lombok.Data;

/**
 * 封装销售单的数据，简单的示意一些
 */
@Data
public class SaleModel {
    /**
     * 销售的商品
     */
    private String goods;
    /**
     * 销售的数量
     */
    private int saleNum;
}
