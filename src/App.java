import abstractFactory.*;
import concreteFactories.android.AndroidMenu;
import concreteFactories.linux.LinuxFactory;
import concreteFactories.windows.WindowsFactory;

import javax.swing.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the menu: 1 for Android, 2 for the current operating system: ");
        int choice = scanner.nextInt();


        UIFactory factory = null;
        if (choice == 1) {
            SwingUtilities.invokeLater(() -> {
                AndroidMenu frame = new AndroidMenu();
                frame.setVisible(true);
            });
        } else if (choice == 2) {
            // Detectar el sistema operativo
            String osName = System.getProperty("os.name").toLowerCase();
            System.out.println("Detected OS: " + osName);

            // Detectar si estamos en Windows o Linux y usar la factoría correspondiente
            if (osName.contains("win")) {
                factory = new WindowsFactory();
            } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("linux")) {
                factory = new LinuxFactory();
            } else {
                factory = null;
                System.out.println("Unsupported operating system.");
                return;
            }
        } else {
            factory = null;
            System.out.println("Invalid choice.");
            return;
        }

        // Crear una instancia del menú para el sistema operativo detectado
        Menu menu = factory.createMenu();

        // Renderizar la ventana del menú
        menu.render();
    }
}