package es.kiwi.Behavioral.observer.mosh;

import java.util.ArrayList;
import java.util.List;

//Observable
public class SubjectPush {
    List<ObserverPush> observers = new ArrayList<>();

    public void addObserver(ObserverPush obs) {
        observers.add(obs);
    }

    public void removeObserver(ObserverPush obs) {
        observers.remove(obs);
    }

    protected void notifyObservers(int value) {
        observers.forEach(observer -> observer.update(value));
    }
}
