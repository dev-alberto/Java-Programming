package Model;
import Model.Exception.*;

/**
 * Created by alber_000 on 3/21/2016.
 */
public interface Command {
    void execute(String[] commandArguments0)throws MyException;
}
