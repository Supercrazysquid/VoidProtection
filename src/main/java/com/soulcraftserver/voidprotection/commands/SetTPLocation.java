package com.soulcraftserver.voidprotection.commands;

import com.soulcraftserver.voidprotection.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTPLocation implements CommandExecutor {

    Main main;

    public SetTPLocation(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;

        if(sender instanceof Player) {
            player = (Player) sender;
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a player to run this command!");
            return false;
        }

        if(player.hasPermission("voidprotection.settplocation")) {
            if(args.length == 0) {
                if(main.getConfig().getInt("protectionlevel") < player.getLocation().getY()) {
                    main.getConfig().set("tplocation", player.getLocation());
                    main.saveConfig();

                    player.sendMessage(ChatColor.GREEN + "You have set the TP location to, X: " + player.getLocation().getBlockX() + " Y: " + player.getLocation().getBlockY() + " Z: " + player.getLocation().getBlockZ());
                } else {
                    player.sendMessage(ChatColor.RED + "Your TP location must be above the protection level!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments!");
            }

        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to run that command!");
        }

        return false;
    }
}
