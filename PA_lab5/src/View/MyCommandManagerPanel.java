package View;

/**
 * Created by Diana on 26.03.2016.
 */

import View.Buttons.ButtonExecute;
import View.Buttons.MyButtonPanel;
import View.TextArea.MyTextPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Diana on 26.03.2016.
 */
public class MyCommandManagerPanel extends JTabbedPane {
    private MyButtonPanel myButtonPanel;
    private MyTextPanel myTextPanel;
    private JTextArea textArea;
    private JComponent panel1;
    private JComponent panel2;
    private ButtonExecute buttonExecute;

    public MyButtonPanel getMyButtonPanel() {
        return myButtonPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public ButtonExecute getButtonExecute() {
        return buttonExecute;
    }

    public MyTextPanel getMyTextPanel() {
        return myTextPanel;
    }

    private void ConstructTab1Panel() {
        panel1 = new JPanel();
        myTextPanel = new MyTextPanel();
        myButtonPanel = new MyButtonPanel();
        textArea = new JTextArea(1, 1);
        buttonExecute = new ButtonExecute();
        JPanel  aux = new JPanel();
        aux.add(buttonExecute);
        textArea.setVisible(true);
        GridLayout gridLayout = new GridLayout(4, 1);
        gridLayout.setVgap(0);
        panel1.setLayout(gridLayout);
        panel1.add(myButtonPanel);
        panel1.add(myTextPanel);
        panel1.add(aux);
        panel1.add(textArea);
    }

    private void ConstructTab2Panel() {
        panel2 = new JPanel();
    }

    public MyCommandManagerPanel() {
        ConstructTab1Panel();
        ConstructTab2Panel();
        addTab("Command Line Music Player", null, panel1, "Does nothing");
        addTab("Tree Music Player", null, panel2, "Does nothing");
    }

}
