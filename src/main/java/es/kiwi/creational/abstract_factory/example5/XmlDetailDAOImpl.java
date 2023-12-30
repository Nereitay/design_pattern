package es.kiwi.creational.abstract_factory.example5;

public class XmlDetailDAOImpl implements OrderDetailDAO {
    /**
     * 示意方法，保存订单子记录
     */
    @Override
    public void saveOrderDetail() {
        System.out.println("now in XmlDetailDAOImpl saveOrderDetail");
    }
}
