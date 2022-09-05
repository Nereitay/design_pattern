package es.kiwi.behavioral.mediator.mosh;

public class TextBoxObs extends UIControlObs{

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyEventHandler();
    }
}
