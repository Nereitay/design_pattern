package es.kiwi.creational.abstract_factory.mosh.material;

import es.kiwi.creational.abstract_factory.mosh.Button;
import es.kiwi.creational.abstract_factory.mosh.TextBox;
import es.kiwi.creational.abstract_factory.mosh.WidgetFactory;

public class MaterialWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new MaterialButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MaterialTextBox();
    }
}
