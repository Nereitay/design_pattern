package es.kiwi.creational.prototype.example8;

public class ConcretePrototype1 implements Prototype {

    private String name;

    @Override
    public Prototype clone() {

        ConcretePrototype1 prototype = new ConcretePrototype1();
        prototype.setName(this.name);

        return prototype;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "now in Prototype1, name = " + this.name;
    }
}
