package es.kiwi.creational.abstract_factory.extension.dao;

public class XmlDAOFactory extends DAOFactory{
    @Override
    public OrderMainDAO createOrderMainDAO() {
        return new XmlMainDAOImpl();
    }

    @Override
    public OrderDetailDAO createOrderDetailDAO() {
        return new XmlDetailDAOImpl();
    }
}
