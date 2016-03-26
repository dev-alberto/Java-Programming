package View.TextArea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Diana on 26.03.2016.
 */
public class MyTextPanel extends JPanel {
    JPanel filePath;
    JPanel option;

    public MyTextPanel() {
        filePath = new MyTextField("File path");
        option = new MyTextField("Command options");
        GridLayout gridLayout = new GridLayout(2, 1);
        setLayout(gridLayout);
        add(filePath);
        add(option);
        //this.pack();
    }
}
