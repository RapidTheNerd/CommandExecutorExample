package me.rtn.cee;/*
 * CommandExecutorExample
 * Copyright (C) 2017 RapidTheNerd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class staffChat implements Listener{

    private final String STAFF_CHAT_PREIFX = ChatColor.translateAlternateColorCodes('&', "&8[&eSC&8] &b");
    private final String NO_PERMISSION = ChatColor.RED + "You do not have permission to use this command";
    private final String PERMISSION_NODE_ENABLE = "litechat.staffchat.enable";
    private final String PERMISSION_NODE_RECEIVE = "litechat.staffchat.receive";

    private ArrayList<String> staff = new ArrayList<String>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("staffchat") && sender.hasPermission(PERMISSION_NODE_ENABLE)){
            player.sendMessage(ChatColor.BLUE + "Staff chat enabled");
            staff.add(player.getName());
            return true;
        } else if(staff.contains(player.getName())){
            staff.remove(player.getName());
            player.sendMessage(ChatColor.BLUE + "Staff chat disabled");
        } else if(!player.hasPermission(PERMISSION_NODE_ENABLE)){
            player.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    @EventHandler
    private void receiveStaffMessage(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(staff.contains(player)){
            event.setCancelled(true);
            if(player.hasPermission(PERMISSION_NODE_RECEIVE)){
                player.sendMessage(STAFF_CHAT_PREIFX + event.getMessage());
            }
        }
    }
}


