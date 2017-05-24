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

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class staffchatListener implements Listener {

    private static ArrayList<Player> onlinePlayers = new ArrayList<Player>();

    public static void getOnlinePlayers(){
        for(Player player : Bukkit.getOnlinePlayers()) {
            onlinePlayers.add(player);
        }
    }

    public void messageStaff(Player pl, String message){
        String format = ChatColor.translateAlternateColorCodes('&', message);
    }

    @EventHandler
    public static void messageStaff(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        if(onlinePlayers.contains(player) && player.hasPermission("litechat.staffchat")){
            //do shit here
        }
    }
}
