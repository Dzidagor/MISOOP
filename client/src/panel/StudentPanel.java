package panel;

import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {

    public StudentPanel() {
        JPanel topPanel = new JPanel();

        JButton addButton = new JButton();
        JButton delButton = new JButton();
        JButton updateButton = new JButton();
        topPanel.add(addButton);
        topPanel.add(delButton);
        topPanel.add(updateButton);
        add(topPanel);

        setLayout(new BorderLayout());


    }
}
