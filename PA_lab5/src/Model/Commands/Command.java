package Model.Commands;
import Model.Exception.*;

/**
 * Created by alber_000 on 3/21/2016.
 */
public interface Command {
    String execute(String[] commandArguments0)throws MyException;
}
