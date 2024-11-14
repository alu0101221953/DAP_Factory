package concreteFactories.android;

import abstractFactory.Menu;

import javax.swing.*;
import java.awt.*;

public class AndroidMenu implements Menu {
    @Override
    public void render() {
        JDialog menuDialog = new JDialog();
        menuDialog.setTitle("Menú Android");
        menuDialog.setSize(200, 150);
        menuDialog.setLayout(new GridLayout(3, 1));
        menuDialog.setLocationRelativeTo(null);
        menuDialog.setUndecorated(true);

        JButton option1 = new JButton("Opción 1");
        option1.setBackground(Color.WHITE);
        option1.setFocusPainted(false);
        option1.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuDialog, "Opción 1 seleccionada", "Menú", JOptionPane.INFORMATION_MESSAGE);
            menuDialog.dispose();
        });

        JButton option2 = new JButton("Opción 2");
        option2.setBackground(Color.WHITE);
        option2.setFocusPainted(false);
        option2.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuDialog, "Opción 2 seleccionada", "Menú", JOptionPane.INFORMATION_MESSAGE);
            menuDialog.dispose();
        });

        JButton option3 = new JButton("Opción 3");
        option3.setBackground(Color.WHITE);
        option3.setFocusPainted(false);
        option3.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuDialog, "Opción 3 seleccionada", "Menú", JOptionPane.INFORMATION_MESSAGE);
            menuDialog.dispose();
        });

        menuDialog.add(option1);
        menuDialog.add(option2);
        menuDialog.add(option3);

        menuDialog.setVisible(true);
    }
}
