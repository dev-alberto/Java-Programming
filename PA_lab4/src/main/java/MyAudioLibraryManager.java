import utils.PathManager;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Diana on 12.03.2016.
 */
public class MyAudioLibraryManager {
    private PathManager pathManager;
    private List<File> favouriteSongs;

    MyAudioLibraryManager() {
        favouriteSongs = new ArrayList<File>();
        pathManager = new PathManager();
    }

    public void execute() throws IOException, UnsupportedAudioFileException {
        String currentCommand[], line;
        Scanner console = new Scanner(System.in);
        CommandManager commandManager = new CommandManager();

        do {
            line = console.nextLine();
            currentCommand = line.split(" ");

            if (!currentCommand[0].equals("exit")) {
                commandManager.execute(currentCommand);
            }

        }while(!currentCommand[0].equals("exit"));
    }

    public List<File> getFavouriteSongs() {
        return favouriteSongs;
    }
}
