package es.kiwi.behavioral.observer.mosh;

public class SpreadSheet implements Observer{
    @Override
    public void update() {
        System.out.println("SpreadSheet got notified.");
    }
}
