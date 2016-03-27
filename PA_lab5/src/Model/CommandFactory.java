package commands;

import utils.PathManager;
import Exception.*;

/**
 * Factory design pattern. Class used to create different type of object, depending on the user's input.
 */
public class CommandFactory {
    public Command create(PathManager pathManager, String[] commandArguments) throws MyException {
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
        if(commandArguments[0].equals("find")){
            return new CommandFind(pathManager);
        }
        throw new MyException("command not found,please try again");
    }
}
