package com.soulcraftserver.voidprotection;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listener implements org.bukkit.event.Listener {

    Main main;

    public Listener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        if(player.getLocation().getY() < main.getConfig().getInt("protectionlevel")) {
            player.teleport((Location) main.getConfig().get("tplocation"));
        }
    }

}
