package es.kiwi.creational.abstract_factory.mosh.ant;

import es.kiwi.creational.abstract_factory.mosh.Button;

public class AntButton implements Button {
    @Override
    public void render() {
        System.out.println("AntButton");
    }
}
