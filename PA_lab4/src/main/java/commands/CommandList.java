package commands;


import utils.PathManager;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import Exception.*;

/**
 *  Class used for implementing the list functionality which lists all audio files in a directory
 */
public class CommandList implements Command {
    private PathManager pathManager;

    public CommandList(PathManager pathManager) {
        this.pathManager = pathManager;
    }

/*
    // TODO: 13.03.2016 de pus la list si cu director dat ca parametru
    public void execute(String[] commandArguments) {
        File[] paths;
        paths = pathManager.getFile().listFiles();
        if (paths != null) {
            for (File file : paths) {
                if (PathManager.isAudio(file)) {
                    System.out.println(file.toString());
                }
            }
        }
    }
    */

    /**
     * Method that lists all audio files in a directory.
     * @param commandArguments user input
     * @throws MyException
     */

    public void execute(String[] commandArguments) throws MyException {
        Path directory= FileSystems.getDefault().getPath(pathManager.getPath());
        try {
            Files.list(directory)
                    .filter(path -> path.getFileName().toString().matches("[^\\.]*\\.(WAV|MP3|VOX|RAW|WMA|wav|mp3|vox|row|wma)"))
                    .forEach(System.out::println);
        } catch (UncheckedIOException e){
            throw  new MyException("You don't have permission to search this directory, please try again\n",e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
