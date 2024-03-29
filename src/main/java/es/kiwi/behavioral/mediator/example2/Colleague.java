package es.kiwi.behavioral.mediator.example2;


public abstract class Colleague {
    private Mediator mediator;
    public Colleague (Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
}
