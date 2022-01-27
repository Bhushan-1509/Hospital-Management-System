import java.awt.*;
import java.io.IOException;

public class DesktopNotificationGenerator{
    public static void generateDesktopNotification(String message,String caption) throws IOException, InterruptedException, AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("file-transfer.ico");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage(caption, message, TrayIcon.MessageType.INFO);
        Thread.sleep(7000);
//        System.exit(0);
    }
}