package es.kiwi.creational.abstract_factory.mosh.material;

import es.kiwi.creational.abstract_factory.mosh.Button;

public class MaterialButton implements Button {
    @Override
    public void render() {
        System.out.println("Material Button");
    }
}
