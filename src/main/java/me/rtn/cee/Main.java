package me.rtn.cee;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Stream;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        Stream.of(
                new CommandExample()
        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
        getCommand("clear").setExecutor(new CommandExample());
    }

    @Override
    public void onDisable() {
    }
}
