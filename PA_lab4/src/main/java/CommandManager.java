import commands.Command;
import commands.CommandFactory;

import utils.PathManager;

/**
 * Created by Diana on 12.03.2016.
 */
public class CommandManager {
    private PathManager pathManager;
    private CommandFactory commandFactory;

    public CommandManager() {
        pathManager = new PathManager();
        commandFactory = new CommandFactory();
    }

    private void printHelpMenu() {
        System.out.println("Help menu is not available now.");
        // % in loc de spatiu
    }

    public void execute(String[] currentCommand) {
        if (currentCommand[0].equals("help")) {
            printHelpMenu();
        }
        else {
            Command command = commandFactory.create(pathManager, currentCommand);
            if (command != null) {
                command.execute(currentCommand);
            }
        }
    }
}
