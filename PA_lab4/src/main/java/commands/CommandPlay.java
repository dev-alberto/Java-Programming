<<<<<<< 65e416ee5d382d004dea1ceae70ab86e4b0af3b6
package commands;

import utils.PathManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import Exception.*;

/**
 * Class used to implement the play functionality, which takes a path and plays the song.
 */
public class CommandPlay implements Command {
    private PathManager pathManager;
    public CommandPlay(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    /**
     * Method that plays the audio file
     * @param commandArguments user input
     * @throws MyException
     */
    public void execute(String[] commandArguments) throws MyException {
        try {
            File file = pathManager.getFilePath(commandArguments[1]);
            if (file != null && PathManager.isAudio(file)) {
                Desktop desktop = Desktop.getDesktop(); // TODO: 13.03.2016 vezi daca astea nu arunca cumva exceptii ---> vezi headlessexception
                desktop.open(file);
                System.out.println(file.toString());
            }
            else {
                System.out.println("Path is not valid or file is not audio.");
            }
        }catch (IOException ioException) {
            throw new MyException("This file is not in current directory",ioException);
        }
        catch (IndexOutOfBoundsException indexOutOfBandsExeption){
            // TODO: 13.03.2016 arunca exceptie cu nr de argumente gresit

            throw new MyException("Wrong number of arguments",indexOutOfBandsExeption);
        }
        catch (HeadlessException headless){
            headless.printStackTrace();
        }
    }
}
=======
package commands;

import utils.PathManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import Exception.*;

/**
 * Class used to implement the play functionality, which takes a path and plays the song.
 */
public class CommandPlay implements Command {
    private PathManager pathManager;
    public CommandPlay(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    /**
     * Method that plays the audio file
     * @param commandArguments user input
     * @throws MyException
     */
    public void execute(String[] commandArguments) throws MyException {
        try {
            File file = pathManager.getFilePath(commandArguments[1]);
            if (file != null && PathManager.isAudio(file)) {
                Desktop desktop = Desktop.getDesktop(); // TODO: 13.03.2016 vezi daca astea nu arunca cumva exceptii ---> vezi headlessexception
                desktop.open(file);
                System.out.println(file.toString());
            }
            else {
                System.out.println("Path is not valid or file is not audio.");
            }
        }catch (IOException ioException) {
            throw new MyException("This file is not in current directory",ioException);
        }
        catch (IndexOutOfBoundsException indexOutOfBandsExeption){
            // TODO: 13.03.2016 arunca exceptie cu nr de argumente gresit

            throw new MyException("Wrong number of arguments",indexOutOfBandsExeption);
        }
        catch (HeadlessException headless){
            headless.printStackTrace();
        }
    }
}
>>>>>>> Refactoring
