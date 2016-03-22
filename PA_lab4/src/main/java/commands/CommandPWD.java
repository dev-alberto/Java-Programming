package commands;

import utils.PathManager;

/**
 * Class used for implementing the pwd command.
 */
public class CommandPWD implements Command {
    PathManager pathManager;
    public CommandPWD(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public boolean execute(String[] commandArguments) {
        System.out.println(pathManager.getPath());
        return true;
    }
}
