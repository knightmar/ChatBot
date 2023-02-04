package fr.knightmar.chatbot.bot.events;

import fr.knightmar.chatbot.ChatBot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class EventManager extends ListenerAdapter {
    private static final JavaPlugin plugin = ChatBot.getPlugin();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.getMessage().getChannel().getId().equals(ChatBot.getConfig("channel_id"))) {
            plugin.getLogger().log(java.util.logging.Level.INFO, event.getMessage().getContentRaw());
            Bukkit.getServer().sendMessage(Component.text(ChatBot.getPlugin().getConfig().getString("header", "[§cDiscord§r] ") + event.getAuthor().getName() + "> " + event.getMessage().getContentRaw().replaceAll("\n", "")));
        }
    }
}
