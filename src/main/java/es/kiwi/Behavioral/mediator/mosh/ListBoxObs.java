package es.kiwi.Behavioral.mediator.mosh;

public class ListBoxObs extends UIControlObs {

    private String selection;

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
        notifyEventHandler();
    }
}
