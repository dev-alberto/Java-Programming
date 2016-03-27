package View.TextArea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Diana on 26.03.2016.
 */
public class MyTextPanel extends JPanel {
    MyTextField filePath;
    MyTextField option;

    public MyTextField getFilePath() {
        return filePath;
    }

    public MyTextField getOption() {
        return option;
    }

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
