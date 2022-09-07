package es.kiwi.creational.abstract_factory.mosh.app;

import es.kiwi.creational.abstract_factory.mosh.Theme;
import es.kiwi.creational.abstract_factory.mosh.WidgetFactory;
import es.kiwi.creational.abstract_factory.mosh.ant.AntButton;
import es.kiwi.creational.abstract_factory.mosh.ant.AntTextBox;
import es.kiwi.creational.abstract_factory.mosh.material.MaterialButton;
import es.kiwi.creational.abstract_factory.mosh.material.MaterialTextBox;

public class ContactForm1 {

    public void render(WidgetFactory factory) {
        factory.createTextBox().render();
        factory.createButton().render();

    }
}
