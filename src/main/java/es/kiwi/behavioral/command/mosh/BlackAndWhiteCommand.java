package es.kiwi.behavioral.command.mosh;

import es.kiwi.behavioral.command.mosh.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Black and white");
    }
}
