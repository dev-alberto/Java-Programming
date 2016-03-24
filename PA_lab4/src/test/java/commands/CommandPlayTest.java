package commands;

import Exception.MyException;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import utils.PathManager;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;




import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Diana on 21.03.2016.
 */

public class CommandPlayTest extends TestCase {
    private String[] getArgs(String s1, String s2) {
        String [] args = new String[2];
        args[0] = s1;
        args[1] = s2;
        return args;
    }

    @Test
    public void testExecute() throws Exception {
        File file = new File("C:/la.mp3");
        PathManager mockedPathManager = mock(PathManager.class);
        when(mockedPathManager.getFilePath("test")).thenReturn(file);
        when(mockedPathManager.isAudio(file)).thenReturn(true);
        Desktop mockedDesktop = mock(Desktop.class);
        Mockito.doNothing().when(mockedDesktop).open(file);

        String [] args = getArgs("play", "test");

        CommandPlay play = mock(CommandPlay.class);
        when(play.setPathManager(mockedPathManager)).thenCallRealMethod();
        when(play.execute(args)).thenCallRealMethod();
        when(play.createDesktop()).thenReturn(mockedDesktop);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        play.setPathManager(mockedPathManager);
        play.execute(args);

        String expectedOutput  = "The file was open.\r\n";
        assertEquals(outContent.toString(), expectedOutput);
    }

    @Test
    public void testCheckThrowIO() throws Exception {
        File file = new File("C:/la.mp3");
        PathManager mockedPathManager = mock(PathManager.class);
        when(mockedPathManager.getFilePath("test")).thenReturn(file);
        when(mockedPathManager.isAudio(file)).thenReturn(true);
        Desktop mockedDesktop = mock(Desktop.class);
        Mockito.doThrow(new IOException()).when(mockedDesktop).open(file);

        String [] args = getArgs("play", "test");

        CommandPlay play = mock(CommandPlay.class);
        when(play.setPathManager(mockedPathManager)).thenCallRealMethod();
        when(play.execute(args)).thenCallRealMethod();
        when(play.createDesktop()).thenReturn(mockedDesktop);

        try {
            play.setPathManager(mockedPathManager);
            play.execute(args);
        } catch (MyException exception) {
            assertThat(exception.getMessage(), is("This file is not in current directory"));
        }

    }

    @Test
    public void testCheckThrowIndexOOB() throws Exception {
        CommandPlay play = new CommandPlay(new PathManager());
        try {
            play.execute(new String[1]);
        } catch (MyException exception) {
            assertThat(exception.getMessage(), is("Wrong number of arguments"));
        }
    }
}