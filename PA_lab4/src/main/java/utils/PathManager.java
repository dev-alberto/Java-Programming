package utils;

import Exception.MyException;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * Handles the path of all commands.
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

    /**
     * Computes the path taking in account the current path and a string that contains information about the command.
     */
    private File processNewPath(String s) {
        String path = s.replace('%', ' ');

        if (s.charAt(0)=='\\') {
            return new File(file.toString() + path);
        }
        return new File(path);
    }

    /**
     * Computes the path for a command that does not change the current directory
     * @param s the command parameter
     * @return a file object
     * @throws MyException
     */
    public File getFilePath(String s) throws MyException {
        File newFile = processNewPath(s);
        if (newFile.exists()) {
            return newFile;
        }
        throw new MyException("The path is not valid");
    }

    public File changePath(String s) throws MyException {
        File newFile = processNewPath(s);
        if (newFile.exists() && newFile.isDirectory()) {
            file = newFile;
            return newFile;
        }
        throw new MyException("The path is not valid");
    }

    /**
     * Tests is a file is an audio file
     * @param  file is the file that will be tested
     * @return true if the file is an audio file and false otherwise
     */
    public boolean isAudio(File file) {
        String extension = FilenameUtils.getExtension(file.toString());
        final String extensions = "WAV, MP3, VOX, RAW, WMA";
        return extension.length() == 3 && extensions.contains(extension.toUpperCase());
    }
}
