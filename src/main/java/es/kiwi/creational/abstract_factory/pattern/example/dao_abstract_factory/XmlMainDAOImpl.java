package es.kiwi.creational.abstract_factory.pattern.example.dao_abstract_factory;

public class XmlMainDAOImpl implements OrderMainDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in XmlMainDAOImpl saveOrderMain");
    }
}
