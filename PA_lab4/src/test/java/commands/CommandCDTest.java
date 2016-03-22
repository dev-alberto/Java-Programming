package commands;

import Exception.*;
import junit.framework.TestCase;
import org.junit.Test;
import utils.PathManager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Diana on 19.03.2016.
 */
public class CommandCDTest extends TestCase {
    @Test
    public void testChangePath() throws Exception {
        PathManager pathManager = new PathManager("E:\\music");
        CommandCD cd = new CommandCD(pathManager);
        String arg[] = new String[2];
        arg[1] = "\\indie";
        cd.execute(arg);
        assertEquals(cd.getPathManager().getPath(), "E:\\music\\indie");
    }

    @Test
    public void testThrowsMyException() throws MyException {
        PathManager pathManager = new PathManager("E:\\music");
        CommandCD cd = new CommandCD(pathManager);
        String arg[] = new String[1];
        try {
            cd.execute(arg);
        } catch (MyException exeption) {
            assertThat(exeption.getMessage(), is("Too few arguments"));
        }
    }
}