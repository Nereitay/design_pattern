package es.kiwi.behavioral.observer.mosh;

public class DataSourcePush extends SubjectPush{

    private int value;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers(value);
    }
}
