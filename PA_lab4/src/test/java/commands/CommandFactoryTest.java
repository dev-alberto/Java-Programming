package commands;

import junit.framework.TestCase;
import commands.*;
import Exception.*;
import org.junit.Test;
import utils.PathManager;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Diana on 20.03.2016.
 */
public class CommandFactoryTest extends TestCase {
    private CommandFactory factory;
    Map<String, Class> format = new HashMap<String, Class>();

    public CommandFactoryTest() {
        factory = new CommandFactory();
        format.put("cd", CommandCD.class);
        format.put("fav", CommandFav.class);
        format.put("find", CommandFind.class);
        format.put("info", CommandINFO.class);
        format.put("list", CommandList.class);
        format.put("play", CommandPlay.class);
        format.put("pwd", CommandPWD.class);
        format.put("report", CommandReport.class);
    }

    private String[] computeArgs(String commandName) {
        String [] args = new String[2];
        args[0] = commandName;
        return args;
    }

    @Test
    public void testReturnDesiredCommandObject() throws MyException {
        for (Map.Entry<String, Class> entry : format.entrySet()) {
            String [] args = computeArgs(entry.getKey());
            Command commandObject = factory.create(new PathManager(), args);
            assertThat(commandObject, instanceOf(entry.getValue()));
        }
    }

    @Test
    public void testThrowCommandNotFound() throws MyException {
        String [] args = computeArgs("bla");
        try {
            factory.create(new PathManager(), args);
        } catch (MyException exception) {
            assertThat(exception.getMessage(), is("command not found,please try again"));
        }
    }

}