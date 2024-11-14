package concreteFactories.android;

import abstractFactory.*;
import javax.swing.*;
import java.awt.*;

public class AndroidMenu extends JFrame implements abstractFactory.Menu { // Especificar el paquete completo de Menu

    public AndroidMenu() {
        // Configuración de la ventana principal para simular una pantalla de móvil
        setTitle("Simulación de Interfaz Android");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear una fábrica de Android
        UIFactory factory = new AndroidFactory();

        // Barra de estado simulada
        JPanel statusBar = new JPanel();
        statusBar.setBackground(new Color(33, 33, 33));
        statusBar.setPreferredSize(new Dimension(getWidth(), 30));
        JLabel statusLabel = new JLabel("12:45 PM");
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        statusBar.add(statusLabel);
        add(statusBar, BorderLayout.NORTH);

        // Panel central que simula la pantalla del dispositivo móvil
        JPanel androidScreen = new JPanel();
        androidScreen.setLayout(new GridLayout(4, 1, 10, 10));
        androidScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        androidScreen.setBackground(new Color(245, 245, 245));

        // Instanciar y agregar los componentes de Android usando la fábrica
        abstractFactory.Button androidButton = factory.createButton();
        JButton buttonComponent = new JButton("Botón Android");
        buttonComponent.setBackground(new Color(56, 142, 60));
        buttonComponent.setForeground(Color.WHITE);
        buttonComponent.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        buttonComponent.addActionListener(e -> androidButton.render());

        abstractFactory.Dialog androidDialog = factory.createDialog();
        JButton dialogButton = new JButton("Mostrar Diálogo");
        dialogButton.setBackground(new Color(33, 150, 243));
        dialogButton.setForeground(Color.WHITE);
        dialogButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        dialogButton.addActionListener(e -> androidDialog.render());

        JButton menuButton = new JButton("Abrir Menú");
        menuButton.setBackground(new Color(255, 193, 7));
        menuButton.setForeground(Color.WHITE);
        menuButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        menuButton.addActionListener(e -> render()); // Usa el método render original de AndroidMenu

        abstractFactory.NotificationCenter notificationCenter = factory.createNotificationCenter();
        JButton notificationButton = new JButton("Mostrar Notificación");
        notificationButton.setBackground(new Color(244, 67, 54));
        notificationButton.setForeground(Color.WHITE);
        notificationButton.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        notificationButton.addActionListener(e ->
                notificationCenter.showNotification("Notificación", "Esta es una notificación de Android")
        );

        // Añadir botones simulados a la pantalla central
        androidScreen.add(buttonComponent);
        androidScreen.add(dialogButton);
        androidScreen.add(menuButton);
        androidScreen.add(notificationButton);

        // Barra de navegación simulada en la parte inferior de la pantalla
        JPanel navigationBar = new JPanel();
        navigationBar.setBackground(new Color(33, 33, 33));
        navigationBar.setPreferredSize(new Dimension(getWidth(), 50));
        navigationBar.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        JButton homeButton = new JButton("⌂");
        homeButton.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(33, 33, 33));
        homeButton.setBorderPainted(false);

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(33, 33, 33));
        backButton.setBorderPainted(false);

        JButton recentButton = new JButton("▢");
        recentButton.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        recentButton.setForeground(Color.WHITE);
        recentButton.setBackground(new Color(33, 33, 33));
        recentButton.setBorderPainted(false);

        navigationBar.add(backButton);
        navigationBar.add(homeButton);
        navigationBar.add(recentButton);

        // Añadir todos los elementos a la ventana principal
        add(statusBar, BorderLayout.NORTH);
        add(androidScreen, BorderLayout.CENTER);
        add(navigationBar, BorderLayout.SOUTH);
    }

    @Override
    public void render() {
        JDialog menuDialog = new JDialog(this, "Menú Android", true);
        menuDialog.setSize(200, 150);
        menuDialog.setLayout(new GridLayout(3, 1));
        menuDialog.setLocationRelativeTo(this);
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
