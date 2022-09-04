package es.kiwi.Structural.decorator.mosh;

public class CloudStreamD implements Stream{

    @Override
    public void write(String data) {
        System.out.println("Storing " + data);
    }

}
