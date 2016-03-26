package View;

import javax.swing.*;


/**
 * Created by alber_000 on 3/20/2016.
 */

public class MainFrame extends JFrame {

    private AudioFileManager audioFileManager;

    public MainFrame()
    {
        super("Audio Player");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        audioFileManager=new AudioFileManager();
        setMinimumSize(this.getSize());
        setLocationByPlatform(true);
        setLocationRelativeTo(null);
        //setContentPane(audioFileManager);
        pack();
        setVisible(true);
    }
    public AudioFileManager getAudioFileManager(){return audioFileManager;}
}
