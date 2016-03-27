package Controller;

import Model.Commands.*;
import Model.utils.PathManager;
import View.Buttons.*;
import View.MySplitPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alber_000 on 3/22/2016.
 */
public class Listener implements ActionListener {
    MySplitPane splitPane;
    PathManager pathManager;

    public Listener() {
        splitPane = new MySplitPane();
        pathManager = new PathManager();
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getCd().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getPlay().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getReport().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getFav().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getInfo().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getFind().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object object=actionEvent.getSource();

        try {
            String[] args = new String[3];
            String solution = null;
            args[1] = splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().getTextField().getText();
            args[2] = splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().getTextField().getText();

            if (object instanceof ButtonCD) {
                args[0] = "cd";
                Command cd = new CommandCD(pathManager);
                solution = cd.execute(args);
            }
            if (object instanceof ButtonPlay) {
                args[0] = "play";
                Command play = new CommandPlay(pathManager);
                solution = play.execute(args);
            }
            if (object instanceof ButtonFav) {
                args[0] = "fav";
                Command fav = new CommandFav(pathManager);
                solution = fav.execute(args);
            }
            if (object instanceof ButtonReport) {
                args[0] = "report";
                Command report = new CommandReport(pathManager);
                solution = report.execute(args);
            }
            if (object instanceof ButtonInfo) {
                args[0] = "info";
                Command info = new CommandINFO(pathManager);
                solution = info.execute(args);
            }
            if (object instanceof ButtonFind) {
                args[0] = "find";
                Command find = new CommandFind(pathManager);
                solution = find.execute(args);
            }

            if (solution != null) {
                splitPane.getMyCommandManagerPanel().getTextArea().setText(solution);
            }
        }catch (Exception e) {
        }
    }
}
