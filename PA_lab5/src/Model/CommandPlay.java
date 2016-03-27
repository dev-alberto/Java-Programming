package commands;

import Exception.MyException;
import utils.PathManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Class used to implement the play functionality, which takes a path and plays the song.
 */
public class CommandPlay implements Command {
    private PathManager pathManager;

    public CommandPlay(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public Desktop createDesktop() throws MyException {
        return Desktop.getDesktop();
    }

    /**
     * Method that plays the audio file
     * @param commandArguments user input
     * @throws MyException
     */
    public boolean execute(String[] commandArguments) throws MyException {
        try {
            File file = pathManager.getFilePath(commandArguments[1]);
            if (file != null && pathManager.isAudio(file)) {
                Desktop desktop = createDesktop();
                desktop.open(file);
                System.out.println("The file was open.");
            }
            else {
                System.out.println("Path is not valid or file is not audio.");
            }
        }catch (IOException ioException) {
            throw new MyException("This file is not in current directory",ioException);
        }
        catch (IndexOutOfBoundsException indexOutOfBandsExeption){
            throw new MyException("Wrong number of arguments",indexOutOfBandsExeption);
        }
        return true;
    }

    public boolean setPathManager(PathManager pathManager) {
        this.pathManager = pathManager;
        return true;
    }
}
