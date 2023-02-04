package fr.knightmar.chatbot.bot;

import fr.knightmar.chatbot.ChatBot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class CreateCommands {
    public static void main(String[] args) throws InterruptedException {
        JDA jda = JDABuilder.createDefault(System.getenv(ChatBot.getConfig("token")))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.awaitReady();
        jda.shutdown();
        System.exit(0);
    }
}
