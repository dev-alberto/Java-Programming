package commands;

import utils.FavouriteSong;
import utils.PathManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandFav implements Command {
    protected final PathManager pathManager;

    public CommandFav(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    protected List<FavouriteSong> deserialize() {
        ObjectInputStream in = null;
        try {
            FileInputStream la = new FileInputStream("serializedListOfSongs.txt");
            in = new ObjectInputStream(la);
            List<FavouriteSong> favouriteSongs = (ArrayList<FavouriteSong>) in.readObject();
            return favouriteSongs;
        } catch (IOException e) {
            System.out.println("An error have occurred and we can't work with preferences.");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<FavouriteSong>();
    }

    private void addFavorites(File file, String mark){
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
                e.printStackTrace();
            }
        }
    }

    public void execute(String[] commandArguments) {
        File file = pathManager.getFilePath(commandArguments[1]);
        if (file != null && PathManager.isAudio(file)) {
            addFavorites(file, commandArguments[2]);
        }
        else {
            System.out.println("Path is not valid or file is not audio.");
        }
    }
}
