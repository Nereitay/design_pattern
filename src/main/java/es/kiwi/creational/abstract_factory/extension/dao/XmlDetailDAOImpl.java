package es.kiwi.creational.abstract_factory.extension.dao;

public class XmlDetailDAOImpl implements OrderDetailDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in XmlDetailDAOImpl saveOrderDetail");
    }
}
