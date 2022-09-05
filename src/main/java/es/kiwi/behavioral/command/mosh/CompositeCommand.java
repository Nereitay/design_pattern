package es.kiwi.behavioral.command.mosh;

import es.kiwi.behavioral.command.mosh.fx.Command;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements Command {
    private List<Command> commands = new ArrayList<>();

    public void add(Command command){
        commands.add(command);
    }
    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }
}
