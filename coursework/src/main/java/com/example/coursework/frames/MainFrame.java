package com.example.coursework.frames;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        super("Курсовая работа");
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Профиль", new JButton("Профиль"));
        tabbedPane.addTab("Студенты", new JButton("Студенты"));
        tabbedPane.addTab("Бригады", new JButton("Бригады"));
        tabbedPane.addTab("Образцы", new JButton("Образцы"));

        setLayout(new BorderLayout());
        add(tabbedPane);
    }
}
