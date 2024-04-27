package ch.ksrminecraft.weatherplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

    // wenn man auf einen leeren Slot klickt, soll nichts passieren
        if (event.getCurrentItem() == null) {
            return;
        }

        // wenn das Admin-GUI-Menü geöffnet wird
        if (event.getView().getTitle().equalsIgnoreCase("Wetter-GUI")) {
            Player player = (Player) event.getWhoClicked();

            // Die Items sollen nicht bewegt werden können
            event.setCancelled(true);

            CommandSender console = Bukkit.getServer().getConsoleSender();;

            // Entscheidungskriterium ist das gesetzte localisedName
            if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "weather_sun":
                        player.sendRawMessage("schön");
                        Bukkit.dispatchCommand(console, "weather clear");
                        player.closeInventory();
                        break;
                    case "weather_storm":
                        Bukkit.dispatchCommand(console, "weather rain");
                        player.closeInventory();
                        break;
                    case "noon":
                        Bukkit.dispatchCommand(console, "time set day");
                        player.closeInventory();
                        break;
                    case "midnight":
                        console = Bukkit.getServer().getConsoleSender();
                        Bukkit.dispatchCommand(console, "time set midnight");
                        player.closeInventory();
                        break;
                }
            }
        }
    }
}