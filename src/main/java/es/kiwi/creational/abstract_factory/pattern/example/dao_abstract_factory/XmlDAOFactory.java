package es.kiwi.creational.abstract_factory.pattern.example.dao_abstract_factory;

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
