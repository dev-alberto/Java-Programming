package commands;

import junit.framework.TestCase;
import utils.PathManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Diana on 22.03.2016.
 */
public class CommandPWDTest extends TestCase {

    public void testExecute() throws Exception {
        CommandPWD pwd = new CommandPWD(new PathManager());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        pwd.execute(new String[1]);
        String expectedOutput  = "C:\r\n";
        assertEquals(outContent.toString(), expectedOutput);
    }
}