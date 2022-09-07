package es.kiwi.creational.abstract_factory.mosh.app;

import es.kiwi.creational.abstract_factory.mosh.Theme;
import es.kiwi.creational.abstract_factory.mosh.ant.AntButton;
import es.kiwi.creational.abstract_factory.mosh.ant.AntTextBox;
import es.kiwi.creational.abstract_factory.mosh.material.MaterialButton;
import es.kiwi.creational.abstract_factory.mosh.material.MaterialTextBox;

public class ContactForm {

    public void render(Theme theme) {

        if (theme == Theme.ANT) {
            new AntTextBox().render();
            new AntButton().render();
        } else if (theme == Theme.MATERIAL) {
            new MaterialTextBox().render();
            new MaterialButton().render();
        }

    }
}
