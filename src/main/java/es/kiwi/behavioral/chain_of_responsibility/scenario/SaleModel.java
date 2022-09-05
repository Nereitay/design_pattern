package es.kiwi.behavioral.chain_of_responsibility.scenario;

/**
 * 为了封装销售单的数据，简单地示意一下
 */
public class SaleModel {
    /**
     * 销售的商品
     */
    private String goods;

    /**
     * 销售的数量
     */
    private int saleNum;

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    @Override
    public String toString() {
        return "SaleModel{" +
                "goods='" + goods + '\'' +
                ", saleNum=" + saleNum +
                '}';
    }
}
