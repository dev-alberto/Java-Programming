package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alber_000 on 3/21/2016.
 */
public class MySplitPane extends JSplitPane
{
    //JTextArea input=new JTextArea();;
    //JTextArea output=new JTextArea();
    //JScrollPane jScrollPaneLeft=new JScrollPane(input);
    //JScrollPane jScrollPaneRight=new JScrollPane(output);


    public MySplitPane(Container container1, Container container2)
    {
        super(JSplitPane.HORIZONTAL_SPLIT);
        //add(jScrollPaneLeft);
        //add(jScrollPaneRight);
        add(container1);
        add(container2);
        setResizeWeight(0.5);
        setVisible(true);
    }
}
