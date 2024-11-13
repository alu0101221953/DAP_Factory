package concreteFactories.windows;

import abstractFactory.NotificationCenter;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class WindowsNotificationCenter implements NotificationCenter {

    @Override
    public void showNotification(String title, String message) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("img/icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");

            try {
                tray.add(trayIcon);
                trayIcon.displayMessage(title, message, MessageType.INFO);
                System.out.println("Notification displayed: " + title + " - " + message);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("System tray not supported!");
        }
    }

    public void showSystemInfoNotification() {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem os = systemInfo.getOperatingSystem();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        String systemInfoMessage = String.format("OS: %s\nCPU: %s\nMemory: %d bytes",
                os, processor, memory.getTotal());

        showNotification("System Information", systemInfoMessage);
    }
}