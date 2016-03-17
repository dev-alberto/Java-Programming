package commands;

import utils.PathManager;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandPWD implements Command {
    PathManager pathManager;
    public CommandPWD(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public void execute(String[] commandArguments) {
        System.out.println(pathManager.getPath());
    }
}
