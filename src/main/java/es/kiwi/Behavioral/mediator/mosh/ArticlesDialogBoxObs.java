package es.kiwi.Behavioral.mediator.mosh;

public class ArticlesDialogBoxObs{

    private ListBoxObs articlesListBox = new ListBoxObs();
    private TextBoxObs titleTextBox = new TextBoxObs();
    private ButtonObs saveBotton = new ButtonObs();

    public ArticlesDialogBoxObs() {
        articlesListBox.addEventHandler(this::articleSelected);
        titleTextBox.addEventHandler(this:: titleChanged);
    }

    private void titleChanged() {
        String content = titleTextBox.getContent();
        boolean isEmpty = (content == null || content.isEmpty());
        saveBotton.setEnabled(!isEmpty);
    }

    private void articleSelected() {
        titleTextBox.setContent(articlesListBox.getSelection());
        saveBotton.setEnabled(true);
    }

    public void simulationUserInteraction() {
        articlesListBox.setSelection("Article 1");
        titleTextBox.setContent("");
        titleTextBox.setContent("Article 2");
        System.out.println("TextBox: " + titleTextBox.getContent());
        System.out.println("Button: " + saveBotton.isEnabled());
    }
}
