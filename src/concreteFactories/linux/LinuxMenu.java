package concreteFactories.linux;

import abstractFactory.Menu;
import javax.swing.*;
import java.awt.*;

public class LinuxMenu implements Menu {

    @Override
    public void render() {
        JFrame frame = new JFrame("Linux Style Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save");
        JMenuItem menuItem3 = new JMenuItem("Exit");

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.addSeparator();
        menu.add(menuItem3);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Create buttons
        JButton button1 = new JButton("Create Linux Button");
        JButton button2 = new JButton("Create Linux Dialog");
        JButton button3 = new JButton("Show Notification");
        JButton button4 = new JButton("Show System Info");
        JButton button5 = new JButton("Show User Notification");

        // Add action listeners to buttons
        button1.addActionListener(e -> {
            LinuxButton linuxButton = new LinuxButton();
            linuxButton.render();
        });

        button2.addActionListener(e -> {
            LinuxDialog linuxDialog = new LinuxDialog();
            linuxDialog.render();
        });

        button3.addActionListener(e -> {
            LinuxNotificationCenter notificationCenter = new LinuxNotificationCenter();
            notificationCenter.showNotification("Notification Title", "This is a Linux notification.");
        });

        button4.addActionListener(e -> {
            LinuxNotificationCenter notificationCenter = new LinuxNotificationCenter();
            notificationCenter.showSystemInfoNotification();
        });

        button5.addActionListener(e -> {
            LinuxNotificationCenter notificationCenter = new LinuxNotificationCenter();
            notificationCenter.showNotification("User Notification", "This is a user notification.");
        });

        // Add buttons to the frame
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(button4);
        panel.add(button5);
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        bottomPanel.add(button3);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
