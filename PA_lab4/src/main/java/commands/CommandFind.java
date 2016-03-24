package commands;
import Exception.*;
import utils.PathManager;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.regex.Pattern;

/**
 * Class used for implementing the find functionality which lists all audio files in a directory and its subdirectories
 */
public class CommandFind implements Command  {
    private PathManager pathManager;
    public CommandFind(PathManager pathManager){this.pathManager=pathManager;}

    /**
     * Method that takes a path and returns all audio files in the directory tree. Files.walk() returns a lazy Stream of all descend files.
     * We filter the results using a regular expression
     * @param commandArguments user input
     * @throws MyException
     */
    public boolean execute(String[] commandArguments) throws MyException {
        Path start = FileSystems.getDefault().getPath(pathManager.getPath());
        String charactersInSongName = "([a-zA-Z0-9& ]|-)*";
        try{
            Pattern pattern = Pattern.compile("[A-Z]*: " + commandArguments[1]);
            Files.walk(start)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> path.toString().matches(pattern.toString()))
                    .forEach(System.out::println);
        }catch (UncheckedIOException | IOException e){
            throw new MyException("You don't have permission to search this directory tree" +
                    "or the directory does not exists, please try again\n", e);
        }
        catch (IndexOutOfBoundsException e) {
            throw new MyException("Too few parameters.", e);
        }
        return true;
    }
}
