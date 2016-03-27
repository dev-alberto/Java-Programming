package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alber_000 on 3/21/2016.
 */
public class MySplitPane extends JSplitPane {
    MainFrame mainFrame;
    MyCommandManagerPanel myCommandManagerPanel;

    public MyCommandManagerPanel getMyCommandManagerPanel() {
        return myCommandManagerPanel;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public MySplitPane() {
        super(JSplitPane.HORIZONTAL_SPLIT);
        mainFrame=new MainFrame();
        myCommandManagerPanel = new MyCommandManagerPanel();
        mainFrame.setMinimumSize(new Dimension(700,400));
        mainFrame.getAudioFileManager().add(this);
        mainFrame.setContentPane(mainFrame.getAudioFileManager());
        mainFrame.setVisible(true);
        add(myCommandManagerPanel);
        add(mainFrame.getAudioFileManager().getTree());
        setResizeWeight(0.75);
        setVisible(true);
    }
}
