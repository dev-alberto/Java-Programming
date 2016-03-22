package View;

import View.AudioFileManager;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;

/**
 * Created by alber_000 on 3/20/2016.
 */

public class MainFrame extends JFrame {
   // private JTree tree;
   // private JScrollPane jScrollPane;
  //  private MytoolBar mytoolBar=new MytoolBar();
  //  private MySplitPane mySplitPane;
    private AudioFileManager audioFileManager;

    public MainFrame()
    {
        super("Audio Player");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        audioFileManager=new AudioFileManager();
        setMinimumSize(this.getSize());
        setLocationByPlatform(true);
        setLocationRelativeTo(null);
        //makeTree();
        //makeScroll();
       // mySplitPane=new MySplitPane(mytoolBar,tree);
       // audioFileManager.add(mySplitPane);
        //audioFileManager.add(tree);
        setContentPane(audioFileManager);
        pack();
        setVisible(true);
    }
   /*
    private void makeScroll()
    {
        jScrollPane=new JScrollPane(tree);
        tree.setVisibleRowCount(15);
        Dimension preferredSize =  jScrollPane.getPreferredSize();
        Dimension widePreferred = new Dimension(
                250,
                (int)preferredSize.getHeight());
        jScrollPane.setPreferredSize( widePreferred );
        jScrollPane.setVisible(true);
    }
    */
    public AudioFileManager getAudioFileManager(){return audioFileManager;}
}
