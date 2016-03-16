package commands;

import utils.PathManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandPlay implements Command {
    private PathManager pathManager;
    public CommandPlay(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    public void execute(String[] commandArguments) {
        try {
            File file = pathManager.getFilePath(commandArguments[1]);
            if (file != null && PathManager.isAudio(file)) {
                Desktop desktop = Desktop.getDesktop(); // TODO: 13.03.2016 vezi daca astea nu arunca cumva exceptii
                desktop.open(file);
                System.out.println(file.toString());
            }
            else {
                System.out.println("Path is not valid or file is not audio.");
            }
        }catch (IOException ioException) {
            System.out.println("This file is not in current directory");
        }
        catch (IndexOutOfBoundsException indexOutOfBandsExeption){
            // TODO: 13.03.2016 arunca exceptie cu nr de argumente gresit
        }
    }
}
