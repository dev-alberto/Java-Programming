package commands;

import Exception.MyException;
import utils.PathManager;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class used for implementing the find functionality which lists all audio files in a directory and its subdirectories
 */
public class CommandFind implements Command  {
    private PathManager pathManager;
    public CommandFind(PathManager pathManager){this.pathManager=pathManager;}

    private boolean isMatching(String path, String field, String pattern) {
        File file = new File(path);
        String data = new String();
        try {
            if (field.toUpperCase().equals("ARTIST")) {
                data = CommandINFO.getArtist(file);
            }

            if (field.toUpperCase().equals("ALBUM")) {
                data = CommandINFO.getArtist(file);
            }

            if (field.toUpperCase().equals("TITLE")) {
                data = CommandINFO.getArtist(file);
            }

            if (field.toUpperCase().equals("YEAR")) {
                data = CommandINFO.getArtist(file);
            }
        }
        catch (Exception e) {
            return false;
        }
        if (data != null) {
            return data.matches(pattern);
        }
        return false;
    }

    /**
     * Method that takes a path and returns all audio files in the directory tree. Files.walk() returns a lazy Stream of all descend files.
     * We filter the results using a regular expression
     * @param commandArguments user input
     * @throws MyException
     */
    public boolean execute(String[] commandArguments) throws MyException {
        Path start = FileSystems.getDefault().getPath(pathManager.getPath());
        try{
            Files.walk(start)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> isMatching(path.toString(), commandArguments[1], commandArguments[2]))
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
