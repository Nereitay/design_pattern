package es.kiwi.creational.abstract_factory.mosh.material;

import es.kiwi.creational.abstract_factory.mosh.TextBox;

public class MaterialTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Material TextBox");
    }
}
