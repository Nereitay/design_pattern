package es.kiwi.Creational.simple_factory.solution;

public class ImplA implements Api{

    @Override
    public void operation(String s) {
        System.out.println("ImplA s == " + s);
    }
}
