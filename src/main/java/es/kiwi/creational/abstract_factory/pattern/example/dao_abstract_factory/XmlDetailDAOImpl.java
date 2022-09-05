package es.kiwi.creational.abstract_factory.pattern.example.dao_abstract_factory;

public class XmlDetailDAOImpl implements OrderDetailDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in XmlDetailDAOImpl saveOrderDetail");
    }
}
