package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alber_000 on 3/21/2016.
 */
public class MySplitPane extends JSplitPane {
    MainFrame mainFrame;
    JPanel mycommandManagerPanel;
    public MySplitPane() {
        super(JSplitPane.HORIZONTAL_SPLIT);
        mainFrame=new MainFrame();
        mycommandManagerPanel = new MyCommandManagerPanel();
        mainFrame.setMinimumSize(new Dimension(700,400));
        mainFrame.getAudioFileManager().add(this);
        mainFrame.setContentPane(mainFrame.getAudioFileManager());
        mainFrame.setVisible(true);
        add(mycommandManagerPanel);
        add(mainFrame.getAudioFileManager().getTree());
        setResizeWeight(0.75);
        setVisible(true);
    }
}
