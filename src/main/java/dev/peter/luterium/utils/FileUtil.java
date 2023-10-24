package dev.peter.luterium.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Peter
 * @since 08/26/2022 (I'm back!)
 */

public class FileUtil {
    protected int length;
    protected InputStream inputStream;
    protected OutputStream outputStream;
    protected Thread thread;

    protected final byte[] bytes = new byte[2048];

    public static List<File> getFiles(String dir)
    {
        try { try (Stream<Path> paths = Files.walk(Paths.get(dir))) {
            return paths.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
        } } catch (Exception ignored) { }
        return new ArrayList<>();
    }

    public static Optional<File> getFile(String name)
    {
        return Optional.of(new File(name));
    }

    public void downloadFile(String url, File dir) {
        thread = new Thread(() -> {
            if (!dir.exists()) {
                try {
                    final URL url1 = new URL(url);
                    final URLConnection connection = url1.openConnection();
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30 ChromePlus/1.6.3.1");
                    inputStream = connection.getInputStream();
                    outputStream = Files.newOutputStream(dir.toPath());
                    while ((length = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, length);
                    }
                    outputStream.close();
                    inputStream.close();
                } catch (Exception ignored) {
                }
            }
        });
        thread.start();
    }

    public static void copyFile(String sourceDirectory, String destinationDirectory, String fileName) {
        File sourceFile = new File(sourceDirectory, fileName);
        File destinationFile = new File(destinationDirectory, fileName);

        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error copying the file: " + e.getMessage());
        }
    }
}
