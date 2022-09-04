package es.kiwi.Behavioral.command.mosh;

import es.kiwi.Behavioral.command.mosh.editor.BoldCommand;
import es.kiwi.Behavioral.command.mosh.editor.History;
import es.kiwi.Behavioral.command.mosh.editor.HtmlDocument;
import es.kiwi.Behavioral.command.mosh.editor.UndoCommand;
import es.kiwi.Behavioral.command.mosh.fx.Button;
import es.kiwi.Behavioral.command.mosh.fx.Command;

public class Main {

    public static void main(String[] args) {

        CustomerService service = new CustomerService();
        Command command = new AddCustomerCommand(service);
        Button button = new Button(command);

        button.click();

        System.out.println("-------------Composite Command----------------");

        CompositeCommand composite = new CompositeCommand();
        composite.add(new ResizeCommand());
        composite.add(new BlackAndWhiteCommand());

        composite.execute();
        composite.execute();

        System.out.println("-------------Undoable Command----------------");

        History history = new History();
        HtmlDocument document = new HtmlDocument();
        document.setContent("Hello World");

        BoldCommand boldCommand = new BoldCommand(document, history);
        boldCommand.execute();
        System.out.println(document.getContent());

        /*boldCommand.unexecute();
        System.out.println(document.getContent());*/

        UndoCommand undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println(document.getContent());

    }



}
