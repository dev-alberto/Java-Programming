package commands;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import utils.PathManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandINFO implements Command {
    private PathManager pathManager;
    public CommandINFO(PathManager pathManager) {
        this.pathManager = pathManager;
    }

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

    private void printMetaData(Metadata metadata) {
        String[] metadataNames = metadata.names();
        for (String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }
        System.out.println();
    }

    public void execute(String[] commandArguments) {
        File file = pathManager.getFilePath(commandArguments[1]);

        if (file != null && PathManager.isAudio(file)) {
            Metadata metadata = getMetaData(file);
            if (metadata != null) {
                printMetaData(metadata);
            }
        }
        else {
            //// TODO: 13.03.2016 arunca exceptie de a noastra
            System.out.println("Path is not valid or file is not audio.");
        }
    }
}
