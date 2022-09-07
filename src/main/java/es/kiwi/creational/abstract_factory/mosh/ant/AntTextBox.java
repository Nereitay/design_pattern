package es.kiwi.creational.abstract_factory.mosh.ant;

import es.kiwi.creational.abstract_factory.mosh.TextBox;

public class AntTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("AntTextBox");
    }
}
