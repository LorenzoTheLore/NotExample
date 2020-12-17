package me.thelore.notexample;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Mein extends JavaPlugin implements Listener {

    public static Mein pl;

    public void onEnable() {
        pl = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public static Mein getPl() {
        return pl;
    }

    @EventHandler
    public void on(PlayerMoveEvent e) {
        if(e.getFrom().getX() != e.getTo().getX() && e.getFrom().getY() != e.getTo().getY() && e.getFrom().getZ() != e.getTo().getZ()) {
            getPl().getConfig().set("balance", getConfig().getInt("balance") + 1);
            getPl().saveConfig();
        }
    }

}
