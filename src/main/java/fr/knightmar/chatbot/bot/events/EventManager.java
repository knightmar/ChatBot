package fr.knightmar.chatbot.bot.events;

import fr.knightmar.chatbot.ChatBot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class EventManager extends ListenerAdapter {
    private static final JavaPlugin plugin = ChatBot.getPlugin();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.getMessage().getChannel().getId().equals("1067466350701846629")) {
            plugin.getLogger().log(java.util.logging.Level.INFO, event.getMessage().getContentRaw());
            plugin.getServer().sendMessage(Component.text("[" + ChatColor.RED + "Discord" + ChatColor.RESET + "] " + event.getAuthor().getName() + "> " + event.getMessage().getContentRaw().replaceAll("\n", "")));
        }
    }
}
