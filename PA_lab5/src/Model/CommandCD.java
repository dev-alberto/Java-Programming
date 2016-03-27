package commands;

import utils.PathManager;
import Exception.*;

/**
 * Class used for implementing the change directory command, cd.
 */
public class CommandCD implements Command {
    PathManager pathManager;
    public CommandCD(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public PathManager getPathManager() {
        return pathManager;
    }

    public boolean execute(String[] commandArguments) throws MyException  {
        try {
            pathManager.setFile(pathManager.changePath(commandArguments[1]));
        }
        catch (IndexOutOfBoundsException exception){
            throw new MyException("Too few arguments",exception);
        }
        return true;
    }

}
