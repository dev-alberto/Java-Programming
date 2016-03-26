package View.Buttons;

import javax.swing.*;

/**
 * Created by alber_000 on 3/21/2016.
 */

public class MyButtonPanel extends JPanel
{
    private JButton cd;
    private JButton find;
    private JButton play;
    private JButton list;
    private JButton report;
    private JButton fav;
    private JButton info;

    public MyButtonPanel() {
        cd = new ButtonCD();
        find = new ButtonFind();
        play = new ButtonPlay();
        list = new ButtonList();
        report = new ButtonReport();
        fav = new ButtonFav();
        info = new ButtonInfo();

        add(cd);
        add(list);
        add(play);
        add(find);
        add(fav);
        add(report);
        setSize(200,200);
        setVisible(true);
    }

    public JButton getCd() {
        return cd;
    }

    public JButton getFind() {
        return find;
    }

    public JButton getPlay() {
        return play;
    }

    public JButton getList() {
        return list;
    }

    public JButton getReport() {
        return report;
    }

    public JButton getFav() {
        return fav;
    }

    public JButton getInfo() {
        return info;
    }
}
