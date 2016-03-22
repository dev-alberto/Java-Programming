package Model;
import Model.Exception.*;
import Model.utils.PathManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by alber_000 on 3/22/2016.
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
                Desktop desktop = Desktop.getDesktop();
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