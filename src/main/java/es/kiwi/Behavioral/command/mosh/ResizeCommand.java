package es.kiwi.Behavioral.command.mosh;

import es.kiwi.Behavioral.command.mosh.fx.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize");
    }
}
