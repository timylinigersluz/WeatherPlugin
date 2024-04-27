package ch.ksrminecraft.weatherplugin.commands;

import ch.ksrminecraft.weatherplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class GUICommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            // Erstellen eines GUI-Menüs als Inventar

            Inventory inventory = Bukkit.createInventory(null, 9, "Wetter-GUI");

            // Sonnenblume an Position 0 im Inventar setzen für schönes Wetter
            inventory.setItem(0, new ItemBuilder(Material.SUNFLOWER).setDisplayname("schönes Wetter").setLocalizedName("weather_sun").build());

            // Wassereimer für schlechtes Wetter
            inventory.setItem(2, new ItemBuilder(Material.WATER_BUCKET).setDisplayname("Regen").setLocalizedName("weather_storm").build());

            // Kachel für Time Set Noon
            inventory.setItem(5, new ItemBuilder(Material.CLOCK).setDisplayname("Mittag").setLocalizedName("noon").build());

            // Kachel für Time Set Midnight
            inventory.setItem(7, new ItemBuilder(Material.DARK_OAK_BUTTON).setDisplayname("Mitternacht").setLocalizedName("midnight").build());

            player.openInventory(inventory);

        }

        return true;
    }
}
