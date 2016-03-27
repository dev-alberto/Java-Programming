package View.TextArea;

import javax.swing.*;

/**
 * Created by Diana on 26.03.2016.
 */
public class MyTextField extends JPanel {
    JLabel label;
    JTextField textField;
    public MyTextField(String s) {
        label = new JLabel(s);
        textField = new JTextField();
        textField.setColumns(30);
        add(label);
        add(textField);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JLabel getLabel() {
        return label;
    }
}
