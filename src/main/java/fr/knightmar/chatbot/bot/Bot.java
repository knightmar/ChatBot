package fr.knightmar.chatbot.bot;

import fr.knightmar.chatbot.bot.events.EventManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {
    public static JDA jda = null;
    public static void runBot() throws InterruptedException {
        jda = JDABuilder.createDefault(System.getenv("TOKEN"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new EventManager())
                .build();

        jda.awaitReady();
    }

    public static void sendMessage(String message) {
        jda.getTextChannelById("1067466350701846629").sendMessage(message.trim()).queue();
    }

    public static void main(String[] args) {
        try {
            runBot();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
