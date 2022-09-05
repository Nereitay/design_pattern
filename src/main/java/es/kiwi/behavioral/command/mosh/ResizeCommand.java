package es.kiwi.behavioral.command.mosh;

import es.kiwi.behavioral.command.mosh.fx.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize");
    }
}
