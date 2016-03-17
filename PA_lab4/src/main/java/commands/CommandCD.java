<<<<<<< 65e416ee5d382d004dea1ceae70ab86e4b0af3b6
package commands;

import utils.PathManager;
import Exception.*;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandCD implements Command {
    PathManager pathManager;
    public CommandCD(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public void execute(String[] commandArguments) throws MyException  {
        try {
            pathManager.setFile(pathManager.changePath(commandArguments[1]));
        }
        catch (IndexOutOfBoundsException exception){
            // TODO: 13.03.2016 Arunca exceptie de a noastra in care zici ca ai prea putine argumente!
            throw new MyException("Too few arguments",exception);
        }
    }
}
=======
package commands;

import utils.PathManager;
import Exception.*;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandCD implements Command {
    PathManager pathManager;
    public CommandCD(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public void execute(String[] commandArguments) throws MyException  {
        try {
            pathManager.setFile(pathManager.changePath(commandArguments[1]));
        }
        catch (IndexOutOfBoundsException exception){
            // TODO: 13.03.2016 Arunca exceptie de a noastra in care zici ca ai prea putine argumente!
            throw new MyException("Too few arguments",exception);
        }
    }
}
>>>>>>> Refactoring
