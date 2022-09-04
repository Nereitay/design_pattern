package es.kiwi.Creational.abstract_factory.pattern.example.dao_abstract_factory;

public class RdbMainDAOImpl implements OrderMainDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in RdbMainDAOImpl saveOrderMain");
    }
}
