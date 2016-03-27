package Model.Commands;
import Model.Exception.*;
import Model.utils.PathManager;

/**
 * Created by alber_000 on 3/21/2016.
 */

public class CommandCD implements Command {
    PathManager pathManager;
    public CommandCD(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public String execute(String[] commandArguments) throws MyException  {
        try {
            pathManager.setFile(pathManager.changePath(commandArguments[1]));
            return null;
        }
        catch (IndexOutOfBoundsException exception){
            // TODO: 13.03.2016 Arunca exceptie de a noastra in care zici ca ai prea putine argumente!
            throw new MyException("Too few arguments",exception);
        }
    }
}
