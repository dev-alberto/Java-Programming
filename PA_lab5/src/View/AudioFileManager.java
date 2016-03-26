package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.io.File;

/**
 * Created by alber_000 on 3/20/2016.
 */

public class AudioFileManager extends JPanel
{
    private JTree tree;
    private JScrollPane jScrollPane;

    public AudioFileManager()
    {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));
        makeTree();
        makeScroll();
    }

    private void makeTree()
    {
        FileSystemView fileSystemView=FileSystemView.getFileSystemView();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        File[] roots = fileSystemView.getRoots();
        for (File fileSystemRoot : roots) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
            root.add( node );
            File[] files = fileSystemView.getFiles(fileSystemRoot, true);
            for (File file : files) {
                node.add(new DefaultMutableTreeNode(file));
            }
        }
        tree=new JTree(root);
    }
    private JScrollPane makeScroll()
    {
        jScrollPane=new JScrollPane(tree);
        tree.setVisibleRowCount(15);
        Dimension preferredSize =  jScrollPane.getPreferredSize();
        Dimension widePreferred = new Dimension(
                250,
                (int)preferredSize.getHeight());
        jScrollPane.setPreferredSize( widePreferred );
        jScrollPane.setVisible(true);
        return jScrollPane;
    }


    public JTree getTree(){return tree;}
    public JScrollPane getjScrollPane(){return jScrollPane;}
}
