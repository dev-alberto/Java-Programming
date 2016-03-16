package commands;

import utils.PathManager;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;

/**
 * Created by alber_000 on 3/14/2016.
 */
public class CommandFind implements Command  {
    private PathManager pathManager;
    public CommandFind(PathManager pathManager){this.pathManager=pathManager;}

    public void execute(String[] commandArguments)  {
        Path start = FileSystems.getDefault().getPath(pathManager.getPath());
        Pattern pattern = Pattern.compile("[^\\.]*\\.(WAV|MP3|VOX|RAW|WMA|wav|mp3|vox|row|wma)");
        try {
            Files.walk(start)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> path.toString().matches(pattern)) //ToDO write regex
                    .forEach(System.out.println("lalala"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
