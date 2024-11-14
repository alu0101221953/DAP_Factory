package concreteFactories.android;

import abstractFactory.Dialog;

import javax.swing.*;
import java.awt.*;

public class AndroidDialog implements Dialog {
    @Override
    public void render() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Diálogo Android");
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel("Este es un diálogo estilo Android", SwingConstants.CENTER);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        panel.add(label);

        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(33, 150, 243));
        okButton.setForeground(Color.WHITE);
        okButton.addActionListener(e -> dialog.dispose());

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(okButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
}
