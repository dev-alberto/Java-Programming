package commands;

import org.apache.commons.io.FilenameUtils;
import utils.PathManager;

import java.io.File;

/**
 * Created by Diana on 13.03.2016.
 */
public class CommandList implements Command {
    private PathManager pathManager;

    public CommandList(PathManager pathManager) {
        this.pathManager = pathManager;
    }

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
}
