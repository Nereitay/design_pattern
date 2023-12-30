package es.kiwi.creational.abstract_factory.example5;

public class XmlMainDAOImpl implements OrderMainDAO {
    /**
     * 示意方法，保存订单主记录
     */
    @Override
    public void saveOrderMain() {
        System.out.println("now in XmlMainDAOImpl saveOrderMain");
    }
}
