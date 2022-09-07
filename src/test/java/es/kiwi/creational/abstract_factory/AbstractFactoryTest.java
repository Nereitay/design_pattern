package es.kiwi.creational.abstract_factory;

import es.kiwi.creational.abstract_factory.mosh.ant.AntWidgetFactory;
import es.kiwi.creational.abstract_factory.mosh.app.ContactForm1;
import es.kiwi.creational.abstract_factory.mosh.material.MaterialWidgetFactory;
import org.junit.Test;

public class AbstractFactoryTest {

    /*Provide an interface for creating families of related objects*/
    @Test
    public void mainMosh() {
        new ContactForm1().render(new MaterialWidgetFactory());
        new ContactForm1().render(new AntWidgetFactory());
    }
}
