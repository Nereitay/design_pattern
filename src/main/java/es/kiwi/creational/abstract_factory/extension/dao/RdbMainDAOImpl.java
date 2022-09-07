package es.kiwi.creational.abstract_factory.extension.dao;

public class RdbMainDAOImpl implements OrderMainDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in RdbMainDAOImpl saveOrderMain");
    }
}
