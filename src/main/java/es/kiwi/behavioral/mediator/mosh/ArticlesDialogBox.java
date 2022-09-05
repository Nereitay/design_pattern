package es.kiwi.behavioral.mediator.mosh;

public class ArticlesDialogBox extends DialogBox {

    private ListBox articlesListBox = new ListBox(this);
    private TextBox titleTextBox = new TextBox(this);
    private Button saveBotton = new Button(this);

    @Override
    public void changed(UIControl control) {
        if (control == articlesListBox)
            articleSelected();
        else if (control == titleTextBox)
            titleChanged();

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
