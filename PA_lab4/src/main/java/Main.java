import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Created by Diana on 12.03.2016.
 */
public class Main {
    public static void main(String argv[]) throws IOException, UnsupportedAudioFileException {
        MyAudioLibraryManager myAudioLibraryManager = new MyAudioLibraryManager();
            myAudioLibraryManager.execute();
    }
}
