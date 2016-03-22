package Model.utils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * Created by alber_000 on 3/21/2016.
 */
public class PathManager {
    private File file;

    public PathManager() {
        file = new File("C:");
    }

    public PathManager(String path) {
        file = new File(path);
    }

    public String getPath(){
        return file.toString();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private File processNewPath(String s) {
        String path = s.replace('%', ' ');

        if (s.charAt(0)=='\\') {
            return new File(file.toString() + path);
        }
        return new File(path);
    }


    public File getFilePath(String s) {
        File newFile = processNewPath(s);

        if (newFile.exists()) {
            return newFile;
        }

        System.out.println("The path is not valid");
        return null;
    }

    public File changePath(String s) {
        File newFile = processNewPath(s);

        if (newFile.exists() && newFile.isDirectory()) {
            file = newFile;
            return newFile;
        }

        System.out.println("The path is wrong.");
        return file;
    }

    public static boolean isAudio(File file) {
        String extension = FilenameUtils.getExtension(file.toString());
        final String extensions = "WAV, MP3, VOX, RAW, WMA";
        return extension.length() == 3 && extensions.contains(extension.toUpperCase());
    }
}
