package es.kiwi.creational.abstract_factory.mosh.ant;

import es.kiwi.creational.abstract_factory.mosh.Button;
import es.kiwi.creational.abstract_factory.mosh.TextBox;
import es.kiwi.creational.abstract_factory.mosh.WidgetFactory;

public class AntWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new AntButton();
    }

    @Override
    public TextBox createTextBox() {
        return new AntTextBox();
    }
}
