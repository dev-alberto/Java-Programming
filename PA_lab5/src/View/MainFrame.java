package View;

import javax.swing.*;


/**
 * Created by alber_000 on 3/20/2016.
 */

public class MainFrame extends JFrame {
    private MyTreeManager audioFileManager;

    public MainFrame() {
        super("Audio Player");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        audioFileManager=new MyTreeManager();
        setMinimumSize(this.getSize());
        setLocationByPlatform(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MyTreeManager getAudioFileManager(){return audioFileManager;}
}
