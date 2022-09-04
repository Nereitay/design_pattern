package es.kiwi.Behavioral.command.mosh.editor;

public interface UndoableCommand extends Command{

    void unexecute();
}
