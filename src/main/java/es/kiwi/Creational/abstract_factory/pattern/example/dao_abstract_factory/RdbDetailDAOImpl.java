package es.kiwi.Creational.abstract_factory.pattern.example.dao_abstract_factory;

public class RdbDetailDAOImpl implements OrderDetailDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in RdbDetailDAOImpl saveOrderDetail");
    }
}
