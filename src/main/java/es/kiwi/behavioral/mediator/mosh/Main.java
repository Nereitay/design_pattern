package es.kiwi.behavioral.mediator.mosh;

public class Main {
    public static void main(String[] args) {

        ArticlesDialogBox dialog = new ArticlesDialogBox();
        dialog.simulationUserInteraction();

        System.out.println("-------------Using observer pattern-----------------");

        ArticlesDialogBoxObs articlesDialogBoxObs = new ArticlesDialogBoxObs();
        articlesDialogBoxObs.simulationUserInteraction();


    }
}
