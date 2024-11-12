package concreteFactories.windows;

import abstractFactory.Menu;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class WindowsMenu implements Menu {

    public WindowsMenu() {
        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Customize menu appearance
        UIManager.put("Menu.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("MenuItem.font", new Font("Segoe UI", Font.PLAIN, 14));
    }

    @Override
    public void render() {
        // Create the main window
        JFrame frame = new JFrame("Windows Style Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu menu = new JMenu("File");

        // Create menu items
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save");
        JMenuItem menuItem3 = new JMenuItem("Exit");

        // Add menu items to the menu
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.addSeparator();
        menu.add(menuItem3);

        // Add the menu to the menu bar
        menuBar.add(menu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Make the window visible and centered
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }
}