package concreteFactories.android;

import abstractFactory.Button;

import javax.swing.*;
import java.awt.*;

public class AndroidButton implements Button {
    @Override
    public void render() {
        JButton button = new JButton("Botón Android");
        button.setBackground(new Color(56, 142, 60));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Sans-Serif", Font.BOLD, 16));

        // Mostrar el botón en un cuadro de diálogo para simular su estilo
        JOptionPane.showMessageDialog(null, button, "Botón Android", JOptionPane.PLAIN_MESSAGE);
    }
}
