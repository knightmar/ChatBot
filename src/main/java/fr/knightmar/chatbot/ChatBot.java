package fr.knightmar.chatbot;

import fr.knightmar.chatbot.bot.Bot;
import fr.knightmar.chatbot.minecraft.Events;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatBot extends JavaPlugin {
    private final JavaPlugin plugin = this;
    @Override
    public void onEnable() {
        try {
            Bot.runBot();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        Bot.jda.shutdown();
    }

    public static JavaPlugin getPlugin() {
        return getPlugin(ChatBot.class);
    }
}
