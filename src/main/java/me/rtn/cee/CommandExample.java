package me.rtn.cee;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * Created by George on 27-Apr-17 on Apr at 2:08 AM.
 */
public class CommandExample implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if(player.hasPermission("permissionnodehere")){
            player.getInventory().clear();
            player.sendMessage(ChatColor.BOLD.toString() + ChatColor.WHITE + "Your inventory has been cleared");
        } else {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You do not have permission to use this");
        }

        return false;
    }
}
