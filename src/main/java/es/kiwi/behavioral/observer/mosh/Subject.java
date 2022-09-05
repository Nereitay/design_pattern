package es.kiwi.behavioral.observer.mosh;

import java.util.ArrayList;
import java.util.List;

//Observable
public class Subject {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    protected void notifyObservers() {
        observers.forEach(Observer :: update);
    }
}
