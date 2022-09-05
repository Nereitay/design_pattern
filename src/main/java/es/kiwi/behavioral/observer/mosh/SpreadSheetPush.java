package es.kiwi.behavioral.observer.mosh;

public class SpreadSheetPush implements ObserverPush{
    @Override
    public void update(int value) {
        System.out.println("SpreadSheet got notified: " + value);
    }
}
