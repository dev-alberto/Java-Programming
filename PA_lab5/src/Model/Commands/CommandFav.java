package Model.Commands;

import Model.Exception.MyException;
import Model.utils.FavouriteSong;
import Model.utils.PathManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class used for implementing the fav command, which serializes a list of favorite songs and also provides functionality for deserialization.
 */
public class CommandFav implements Command {
    protected final PathManager pathManager;
    protected static final String serializedListOfSongs = "serializedListOfSongs.txt";

    public CommandFav(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    /**
     * Method which provided the deserialization functionality
     * @return list of favorite songs
     */

    protected List<FavouriteSong> deserialize(File fileName) {
        //System.out.println("FAV");
        ObjectInputStream in = null;
        try {
            FileInputStream la = new FileInputStream(fileName);
            in = new ObjectInputStream(la);
            List<Model.utils.FavouriteSong> favouriteSongs = (List<Model.utils.FavouriteSong>) in.readObject();
            System.out.println(favouriteSongs);
            return favouriteSongs;
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.print(e.getCause()+ "  " + e.getMessage());
        }
        return new ArrayList<Model.utils.FavouriteSong>();
    }

    /**
     * Method used to serialize songs in a file
     * @param pathSong which will contain the serialised songs
     * @param mark string
     * @throws MyException
     */
    private void addFavorites(String serPath, File pathSong, String mark) throws MyException {
        List<FavouriteSong> favouriteSongs = deserialize(new File(serPath));
        if (favouriteSongs != null) {
            favouriteSongs.add(new FavouriteSong(pathSong, mark));
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(serPath));
                out.flush();
                out.writeObject(favouriteSongs);
                out.close();
            } catch (IOException e) {
                throw new MyException("I was not able to add this to list of favorites.", e);
            }
        }
    }

    /**
     * method that performs the add songs to list of favorites
     * @param commandArguments i.e user input
     */
    public String execute(String[] commandArguments) throws MyException {
        File file = pathManager.getFilePath(commandArguments[1]);
        if (file != null && PathManager.isAudio(file)) {
            try {
                addFavorites(serializedListOfSongs, file, commandArguments[2]);
            }
            catch (IndexOutOfBoundsException exception) {
                throw new MyException("Too few arguments",exception);
            }
        }
        else {
            throw new MyException("Path is not valid or file is not audio.");
        }
        return null;
    }
}
