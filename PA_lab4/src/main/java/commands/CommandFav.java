package commands;
import Exception.*;

import utils.FavouriteSong;
import utils.PathManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class used for implementing the fav command, which serializes a list of favorite songs and also provides functionality for deserialization.
 */
public class CommandFav implements Command {
    protected final PathManager pathManager;

    public CommandFav(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    /**
     * Method which provided the deserialization functionality
     * @return list of favorite songs
     */

    protected List<FavouriteSong> deserialize() {
        ObjectInputStream in = null;
        try {
            FileInputStream la = new FileInputStream("serializedListOfSongs.txt");
            in = new ObjectInputStream(la);
            List<FavouriteSong> favouriteSongs = (ArrayList<FavouriteSong>) in.readObject();
            return favouriteSongs;
        } catch (IOException e) {
           e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.print(e.getCause()+ e.getMessage());
        }
        return new ArrayList<FavouriteSong>();
    }

    /**
     * Method used to serialize songs in a file
     * @param file which will contain the serialised songs
     * @param mark string
     * @throws MyException
     */

    private void addFavorites(File file, String mark) throws MyException{
        List<FavouriteSong> favouriteSongs = deserialize();
        if (favouriteSongs != null) {
            favouriteSongs.add(new FavouriteSong(file, mark));
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serializedListOfSongs.txt"));
                out.flush();
                out.writeObject(favouriteSongs);
                out.close();
            } catch (IOException e) {
                // TODO: 13.03.2016 adauga exceptie nu a putut fi adaugat la lista de favorite
                throw new MyException("Ooops, I was not able to add this to list of favorites.",e);
            }
        }
    }

    /**
     * method that performs the add songs to list of favorites
     * @param commandArguments i.e user input
     */

    public void execute(String[] commandArguments) {
        File file = pathManager.getFilePath(commandArguments[1]);
        if (file != null && PathManager.isAudio(file)) {
            try {


                addFavorites(file, commandArguments[2]);
            }catch (MyException myexception){
                System.out.print(myexception.getMessage() + " " + myexception.getCause());
            }
        }
        else {
            System.out.println("Path is not valid or file is not audio.");
        }
    }
}
