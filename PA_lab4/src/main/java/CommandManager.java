import commands.Command;
import commands.CommandFactory;

import utils.PathManager;
import Exception.*;


/**
 * Class used to sort the user input and help the MyAudioLibraryManager provide the shell functionality
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

    /**
     * Method that is used to read the user input and create the correct object(using the CommandFactory)
     * @param currentCommand user input
     */

    public void execute(String[] currentCommand) {
        if (currentCommand[0].equals("help")) {
            printHelpMenu();
        }
        else {
            Command command = null;
            try {
                command = commandFactory.create(pathManager, currentCommand);
            } catch (MyException e) {
                System.out.print(e.getMessage() + "\n");
            }
            if (command != null) {
                try {
                    command.execute(currentCommand);
                }catch (MyException e){
                    System.out.print(e.getMessage() + e.getCause() + "\n");
                }
            }
        }
    }
}
