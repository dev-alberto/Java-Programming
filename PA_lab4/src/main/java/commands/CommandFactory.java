package commands;

import utils.PathManager;

import javax.activation.CommandInfo;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandFactory {
    public Command create(PathManager pathManager, String[] commandArguments) {
        if (commandArguments[0].equals("cd")) {
            return new CommandCD(pathManager);
        }
        if (commandArguments[0].equals("pwd")) {
            return new CommandPWD(pathManager);
        }
        if (commandArguments[0].equals("list")) {
            return new CommandList(pathManager);
        }
        if (commandArguments[0].equals("play")) {
            return new CommandPlay(pathManager);
        }
        if (commandArguments[0].equals("info")) {
            return new CommandINFO(pathManager);
        }
        if (commandArguments[0].equals("fav")) {
            return new CommandFav(pathManager);
        }
        if (commandArguments[0].equals("report")) {
            return new CommandReport(pathManager);
        }
        
        return null;
        // TODO: 13.03.2016 In loc sa returnezi null arunci exceptia comanda necunoscuta sau ceva de genul
    }
}
