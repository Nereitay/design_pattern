package es.kiwi.Behavioral.observer.mosh;

public class Chart implements Observer{
    @Override
    public void update() {
        System.out.println("Chart got notified.");
    }
}
