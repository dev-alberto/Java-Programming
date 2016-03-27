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
    private static String[] args = new String[3];
    private static String solution = null;
    private static Command command = null;

    public Listener() {
        splitPane = new MySplitPane();
        pathManager = new PathManager();
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getCd().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getPlay().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getReport().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getFav().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getInfo().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getFind().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getMyButtonPanel().getList().addActionListener(this);
        splitPane.getMyCommandManagerPanel().getButtonExecute().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object object=actionEvent.getSource();
        try {
            splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(true);
            splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().setVisible(true);
            if (object instanceof ButtonCD) {
                args[0] = "cd";
                command = new CommandCD(pathManager);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(false);
            }
            if (object instanceof ButtonPlay) {
                args[0] = "play";
                command = new CommandPlay(pathManager);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(false);
            }
            if (object instanceof ButtonFav) {
                args[0] = "fav";
                command = new CommandFav(pathManager);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(true);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().getLabel().setText("Mark:");
            }
            if (object instanceof ButtonReport) {
                args[0] = "report";
                command = new CommandReport(pathManager);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(false);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().setVisible(false);
            }
            if (object instanceof ButtonInfo) {
                args[0] = "info";
                command = new CommandINFO(pathManager);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(false);
            }
            if (object instanceof ButtonFind) {
                args[0] = "find";
                command = new CommandFind(pathManager);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(true);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().getLabel().setText("Keyword");
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().getLabel().setText("Value");
            }
            if (object instanceof ButtonList) {
                args[0] = "list";
                command = new CommandList(pathManager);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(false);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().setVisible(false);
            }
            if (object instanceof ButtonExecute) {
                args[1] = splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().getTextField().getText();
                args[2] = splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().getTextField().getText();
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().setVisible(false);
                splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().setVisible(false);
                splitPane.getMyCommandManagerPanel().getTextArea().setText(command.execute(args));
            }
            splitPane.getMyCommandManagerPanel().getMyTextPanel().getFilePath().getTextField().setText("");
            splitPane.getMyCommandManagerPanel().getMyTextPanel().getOption().getTextField().setText("");
        }catch (Exception e) {
        }
    }
}
