package fr.knightmar.chatbot.minecraft.commands;

import fr.knightmar.chatbot.ChatBot;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConfigCommand implements TabExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length >= 2) {
            if (args[0].equals("config")) {
                if (args.length == 2 || args.length == 3) {
                    String arg = args[1].toLowerCase();

                    if (arg.equals("header") || arg.equals("server_id") || arg.equals("channel_id") || arg.equals("token")) {
                        if (args.length == 2) {
                            sender.sendMessage("Current value of '" + arg + "' is: " + ChatBot.getConfig(arg));
                        } else {
                            ChatBot.getPlugin().getConfig().set(arg, ChatColor.translateAlternateColorCodes('&', args[2]) + " ");
                            sender.sendMessage("The new value of '" + arg + "' is: " + ChatBot.getConfig(arg));
                            ChatBot.getPlugin().saveConfig();
                        }

                        return true;
                    }
                }
            }
        }

        sender.sendMessage(ChatColor.RED + "Usage: " + command.getUsage());
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1)
            return List.of("config");
        else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("config")) {
                return Arrays.asList("header", "server_id", "channel_id", "token");
            }
        }

        return Collections.emptyList();
    }
}
