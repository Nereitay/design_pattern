package es.kiwi.creational.abstract_factory.pattern.example.dao_abstract_factory;

public class RdbDAOFactory  extends DAOFactory{
    @Override
    public OrderMainDAO createOrderMainDAO() {
        return new RdbMainDAOImpl();
    }

    @Override
    public OrderDetailDAO createOrderDetailDAO() {
        return new RdbDetailDAOImpl();
    }
}
