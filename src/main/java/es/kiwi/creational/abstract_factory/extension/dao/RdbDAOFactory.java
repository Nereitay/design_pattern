package es.kiwi.creational.abstract_factory.extension.dao;

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
