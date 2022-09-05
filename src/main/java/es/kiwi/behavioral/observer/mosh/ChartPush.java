package es.kiwi.behavioral.observer.mosh;

public class ChartPush implements ObserverPush{
    @Override
    public void update(int value) {
        System.out.println("Chart got notified: " + value);
    }
}
