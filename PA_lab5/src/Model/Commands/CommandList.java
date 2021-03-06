package Model.Commands;


import Model.Exception.MyException;
import Model.utils.PathManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class used for implementing the list functionality which lists all audio files in a directory
 */
public class CommandList implements Command {
    private PathManager pathManager;

    public CommandList(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    /**
     * Method that lists all audio files in a directory.
     * @param commandArguments user input
     * @throws MyException
     */
    public String execute(String[] commandArguments) throws MyException {
        Path directory = Paths.get(pathManager.getPath());
        String solution;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            Files.list(directory)
                    .filter(path -> path.getFileName().toString().matches("[^\\.]*\\.(WAV|MP3|VOX|RAW|WMA|wav|mp3|vox|row|wma)"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new MyException("This file does not exist.");
        }

        return outContent.toString();
    }

}
