import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Main class, used to run the application.
 */
public class Main {
    public static void main(String argv[]) {
        MyAudioLibraryManager myAudioLibraryManager = new MyAudioLibraryManager();
            myAudioLibraryManager.execute();
    }
}
