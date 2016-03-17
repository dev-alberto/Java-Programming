<<<<<<< 65e416ee5d382d004dea1ceae70ab86e4b0af3b6
package commands;
import Exception.*;


/**
 * Interface used by every class that implements some type of command.
 * The one method contained inside the interface takes a user's input and performs a certain task
 */
public interface Command {
    void execute(String[] commandArguments0)throws MyException;
}
=======
package commands;
import Exception.*;


/**
 * Interface used by every class that implements some type of command.
 * The one method contained inside the interface takes a user's input and performs a certain task
 */
public interface Command {
    void execute(String[] commandArguments0)throws MyException;
}
>>>>>>> Refactoring
