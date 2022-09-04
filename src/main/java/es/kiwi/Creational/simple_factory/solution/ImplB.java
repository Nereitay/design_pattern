package es.kiwi.Creational.simple_factory.solution;

public class ImplB implements Api{

    @Override
    public void operation(String s) {
        System.out.println("ImplB s == " + s);
    }
}
