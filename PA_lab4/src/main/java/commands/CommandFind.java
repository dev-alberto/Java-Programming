<<<<<<< 65e416ee5d382d004dea1ceae70ab86e4b0af3b6
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

    public void execute(String[] commandArguments) throws MyException {
        Path start = FileSystems.getDefault().getPath(pathManager.getPath());
        Pattern pattern = Pattern.compile("[^\\.]*\\.(WAV|MP3|VOX|RAW|WMA|wav|mp3|vox|row|wma)");

        try {
            Files.walk(start)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> path.toString().matches(pattern.toString()))
                    .forEach(System.out::println);
        }catch (UncheckedIOException e){
            throw  new MyException("You don't have permission to search this directory tree, please try again\n",e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
=======
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

    public void execute(String[] commandArguments) throws MyException {
        Path start = FileSystems.getDefault().getPath(pathManager.getPath());
        Pattern pattern = Pattern.compile("[^\\.]*\\.(WAV|MP3|VOX|RAW|WMA|wav|mp3|vox|row|wma)");

        try {
            Files.walk(start)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> path.toString().matches(pattern.toString()))
                    .forEach(System.out::println);
        }catch (UncheckedIOException e){
            throw  new MyException("You don't have permission to search this directory tree, please try again\n",e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
>>>>>>> Refactoring
