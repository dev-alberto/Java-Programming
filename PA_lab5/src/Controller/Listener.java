package Controller;

import View.Buttons.ButtonCD;
import View.Buttons.ButtonFind;
import View.Buttons.ButtonPlay;
import View.MainFrame;
import View.MySplitPane;
import View.MytoolBar;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alber_000 on 3/22/2016.
 */
public class Listener implements ActionListener
{

    MytoolBar mytoolBar;
    MainFrame mainFrame;
    MySplitPane mySplitPane;


    public Listener()
    {
        mainFrame=new MainFrame();
        mytoolBar=new MytoolBar();
        mySplitPane=new MySplitPane(mytoolBar,mainFrame.getAudioFileManager().getTree());
        mainFrame.getAudioFileManager().add(mySplitPane);
        mytoolBar.getCd().addActionListener(this);
        mytoolBar.getPlay().addActionListener(this);
        mytoolBar.getFind().addActionListener(this);
    }

    /**
     * Metoda ce va gestiona evenimentele asupra butoanelor
     * @param e evenimentul ce a avut loc
     */

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object object=e.getSource();

        if(object instanceof ButtonPlay)
        {

            JDialog d = new JDialog(mainFrame, "Hello", true);
            d.setLocationRelativeTo(mainFrame);
            d.setVisible(true);
        }

        if(object instanceof ButtonFind)
        {

        }

        if(object instanceof ButtonCD)
        {

        }

    }
}
