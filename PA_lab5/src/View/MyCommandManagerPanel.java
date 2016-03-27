package View;

/**
 * Created by Diana on 26.03.2016.
 */

import View.Buttons.MyButtonPanel;
import View.TextArea.MyTextPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Diana on 26.03.2016.
 */
public class MyCommandManagerPanel extends JPanel {
    MyButtonPanel myButtonPanel;
    MyTextPanel myTextPanel;
    JTextArea textArea;

    public MyButtonPanel getMyButtonPanel() {
        return myButtonPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public MyTextPanel getMyTextPanel() {
        return myTextPanel;
    }

    public MyCommandManagerPanel() {
        myTextPanel = new MyTextPanel();
        myButtonPanel = new MyButtonPanel();
        textArea = new JTextArea(1, 1);
        GridLayout gridLayout = new GridLayout(3, 1);
        gridLayout.setVgap(0);
        setLayout(gridLayout);
        add(myTextPanel);
        add(myButtonPanel);
        add(textArea);
    }


}
