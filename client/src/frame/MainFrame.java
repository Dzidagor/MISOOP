package frame;

import panel.StudentPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        super("Курсовая");
//        Создаем панельку сверху
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Студенты", new StudentPanel());
        tabbedPane.addTab("Преподаватели", new JButton("Преподаватели"));
        tabbedPane.addTab("Образцы", new JButton("Образцы"));
//        Устанавливаем лейаут для ориентирования объектов
        setLayout(new BorderLayout());

        add(tabbedPane);
    }

}
