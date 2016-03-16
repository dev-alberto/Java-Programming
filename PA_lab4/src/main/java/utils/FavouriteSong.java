package utils;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Diana on 13.03.2016.
 */
public class FavouriteSong implements Serializable{
    private File file;
    private String mark;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FavouriteSong(File file, String mark) {
        this.file = file;
        this.mark = mark;

    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
