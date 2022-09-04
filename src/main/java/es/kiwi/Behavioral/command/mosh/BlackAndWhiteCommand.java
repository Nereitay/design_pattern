package es.kiwi.Behavioral.command.mosh;

import es.kiwi.Behavioral.command.mosh.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Black and white");
    }
}
