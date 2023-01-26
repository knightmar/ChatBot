package fr.knightmar.chatbot.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class CreateCommands {
    public static void main(String[] args) throws InterruptedException {
        JDA jda = JDABuilder.createDefault(System.getenv("TOKEN"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.awaitReady();
        jda.shutdown();
        System.exit(0);
    }
}
