import utils.PathManager;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.*;

/**
 * Class used to provide the functionality of a shell
 */
public class MyAudioLibraryManager {
    private PathManager pathManager;
    private List<File> favouriteSongs;

    MyAudioLibraryManager() {
        favouriteSongs = new ArrayList<File>();
        pathManager = new PathManager();
    }

    /**
     * Method that provides the shell functionality. Reads user input and performs the different types of functionality provide by this app
     *
     *
     */

    public void execute()   {
        String currentCommand[], line;
        Scanner console = new Scanner(System.in);
        CommandManager commandManager = new CommandManager();
            do {
                line = console.nextLine();
                currentCommand = line.split(" ");

                if (!currentCommand[0].equals("exit")) {
                commandManager.execute(currentCommand);
            }

            } while (!currentCommand[0].equals("exit"));


    }

    public List<File> getFavouriteSongs() {
        return favouriteSongs;
    }
}
