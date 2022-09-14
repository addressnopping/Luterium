package dev.peter.luterium.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
}
