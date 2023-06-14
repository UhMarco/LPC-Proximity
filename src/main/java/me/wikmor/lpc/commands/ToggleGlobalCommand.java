package me.wikmor.lpc.commands;

import me.wikmor.lpc.LPC;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class ToggleGlobalCommand implements TabExecutor {
    private final LPC plugin;

    public ToggleGlobalCommand (LPC plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            boolean current = !Boolean.TRUE.equals(plugin.globals.get(player.getUniqueId()));
            plugin.globals.put(player.getUniqueId(), current);
            player.sendMessage(ChatColor.GRAY + "Global chat toggled " + (current ? "on" : "off") + ".");
            return true;
        }
        commandSender.sendMessage(ChatColor.RED + "Only players can run this command.");
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.emptyList();
    }
}
