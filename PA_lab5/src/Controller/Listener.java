package Controller;

import View.MySplitPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alber_000 on 3/22/2016.
 */
public class Listener implements ActionListener {
    JSplitPane splitPane;

    public Listener() {
        splitPane = new MySplitPane();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
