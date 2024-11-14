package concreteFactories.android;

import abstractFactory.NotificationCenter;

import javax.swing.*;
import java.awt.*;

public class AndroidNotificationCenter implements NotificationCenter {
    @Override
    public void showNotification(String title, String message) {
        JDialog notificationDialog = new JDialog();
        notificationDialog.setSize(300, 100);
        notificationDialog.setLocationRelativeTo(null);
        notificationDialog.setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(56, 142, 60));
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Sans-Serif", Font.BOLD, 14));

        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 12));

        panel.setLayout(new BorderLayout());
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(messageLabel, BorderLayout.CENTER);

        notificationDialog.add(panel);

        Timer timer = new Timer(2000, e -> notificationDialog.dispose());
        timer.setRepeats(false);
        timer.start();

        notificationDialog.setVisible(true);
    }
}
