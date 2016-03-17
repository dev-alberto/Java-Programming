package commands;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import utils.PathManager;
import Exception.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class used for the the info functionality, i.e displaying the metadata of a certain song
 */
public class CommandINFO implements Command {
    private PathManager pathManager;
    public CommandINFO(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    /**
     * Method for the metadata generation
     * @param file we need data on
     * @return metadata
     */

    private Metadata getMetaData(File file) {
        //Parser method parameters
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            parser.parse(inputStream, handler, metadata, context);
            return metadata;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Method used to print the metadata generated by the getMetaData() method
     * @param metadata generated
     */

    private void printMetaData(Metadata metadata) {
        String[] metadataNames = metadata.names();
        for (String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }
        System.out.println();
    }

    /**
     * Method that provides the info functionaliy on a user given file using the getMetaData and print methods
     * @param commandArguments user input
     * @throws MyException
     */

    public void execute(String[] commandArguments) throws MyException {
        File file = pathManager.getFilePath(commandArguments[1]);

        if (file != null && PathManager.isAudio(file)) {
            Metadata metadata = getMetaData(file);
            if (metadata != null) {
                printMetaData(metadata);
            }
        }
        else {
            //// TODO: 13.03.2016 arunca exceptie de a noastra
            throw new MyException("Path is not valid or file is not audio,please try again \n");
        }
    }
}
