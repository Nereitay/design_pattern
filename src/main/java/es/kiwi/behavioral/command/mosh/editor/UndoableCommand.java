package es.kiwi.behavioral.command.mosh.editor;

public interface UndoableCommand extends Command{

    void unexecute();
}
