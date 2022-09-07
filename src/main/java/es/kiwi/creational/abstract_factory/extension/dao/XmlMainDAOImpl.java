package es.kiwi.creational.abstract_factory.extension.dao;

public class XmlMainDAOImpl implements OrderMainDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("now in XmlMainDAOImpl saveOrderMain");
    }
}
