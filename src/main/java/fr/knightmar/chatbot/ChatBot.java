package fr.knightmar.chatbot;

import fr.knightmar.chatbot.bot.Bot;
import fr.knightmar.chatbot.minecraft.Events;
import fr.knightmar.chatbot.minecraft.commands.ConfigCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatBot extends JavaPlugin {

    public static String getConfig(String key) {
        return ChatBot.getPlugin().getConfig().getString(key);
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

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
