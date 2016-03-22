package View;

import View.Buttons.ButtonCD;
import View.Buttons.ButtonFind;
import View.Buttons.ButtonPlay;

import javax.swing.*;

/**
 * Created by alber_000 on 3/21/2016.
 */

public class MytoolBar extends JToolBar
{
    private ButtonCD cd;
    private ButtonFind find;
    private ButtonPlay play;

    public MytoolBar()
    {
        cd=new ButtonCD();
        find=new ButtonFind();
        play=new ButtonPlay();
        add(cd);
        add(find);
        add(play);
        setSize(200,200);
        setVisible(true);
    }

    public ButtonCD getCd(){return cd;}
    public ButtonPlay getPlay(){return play;}
    public ButtonFind getFind(){return find;}
}
