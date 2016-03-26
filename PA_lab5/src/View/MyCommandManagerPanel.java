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
    JPanel myButtonPanel;
    JPanel myTextPanel;

    public MyCommandManagerPanel() {
        myTextPanel = new MyTextPanel();
        myButtonPanel = new MyButtonPanel();
        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setVgap(0);
        setLayout(gridLayout);
        add(myTextPanel);
        add(myButtonPanel);
    }


}
