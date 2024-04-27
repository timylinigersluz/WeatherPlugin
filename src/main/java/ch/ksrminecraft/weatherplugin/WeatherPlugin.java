package ch.ksrminecraft.weatherplugin;

import ch.ksrminecraft.weatherplugin.commands.GUICommand;
import ch.ksrminecraft.weatherplugin.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WeatherPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("gui").setExecutor(new GUICommand());
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
