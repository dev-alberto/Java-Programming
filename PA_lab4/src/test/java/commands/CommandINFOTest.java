package commands;

import Exception.MyException;
import junit.framework.TestCase;
import org.apache.tika.metadata.Metadata;
import org.junit.Test;
import utils.PathManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Diana on 22.03.2016.
 */
public class CommandINFOTest extends TestCase {

    @Test
    public void testExecuteFileNull() throws Exception {
        File file = new File("C:/la.mp3");
        PathManager mockedPathManager = mock(PathManager.class);
        when(mockedPathManager.getFilePath(null)).thenReturn(file);
        try {
            CommandINFO info = new CommandINFO(mockedPathManager);
            String [] args = new String[2];
            args[0] = "info"; args[1] = "test";
            info.execute(args);
        } catch (MyException exception) {
            assertEquals(exception.getMessage(),
                        "Path is not valid or file is not audio,please try again \n");
        }
    }

    private Metadata constructMetadata() {
        Metadata metadata = new Metadata();
        metadata.set("Artist", "test");
        metadata.set("Album", "test");
        metadata.set("Year", "test");
        metadata.set("Title", "test");
        return metadata;
    }

    @Test
    public void testExecute() throws Exception {
        File file = new File("C:\\");
        PathManager mockedPathManager = mock(PathManager.class);
        when(mockedPathManager.getFilePath("test")).thenReturn(file);
        when(mockedPathManager.isAudio(file)).thenReturn(true);

        Metadata metadataTest = constructMetadata();
        CommandINFO info = mock(CommandINFO.class);
        when(info.getMetaData(file)).thenReturn(metadataTest);

        String [] args = new String[2];
        args[0] = "info"; args[1] = "test";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        info.execute(args);

        String expectedOutput  = "ARTIST: test\nALBUM: test\nYEAR: test\nTITLE: test\r\n";
        assertEquals(outContent.toString(), expectedOutput);
    }
}