package es.kiwi.creational.abstract_factory.extension.dao;

public class RdbDetailDAOImpl implements OrderDetailDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in RdbDetailDAOImpl saveOrderDetail");
    }
}
