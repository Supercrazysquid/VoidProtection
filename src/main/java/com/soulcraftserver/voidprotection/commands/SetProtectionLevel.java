package com.soulcraftserver.voidprotection.commands;

import com.soulcraftserver.voidprotection.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetProtectionLevel implements CommandExecutor {

    Main main;

    public SetProtectionLevel(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(sender.hasPermission("voidprotection.setprotectionlevel")) {
            if(args.length == 0) {
                sender.sendMessage(ChatColor.RED + "You must specify the desired protection level!");
            } else if(args.length == 1) {
                try {
                    int ylevel = Integer.parseInt(args[0]);

                    main.getConfig().set("protectionlevel", ylevel);
                    main.saveConfig();

                    sender.sendMessage(ChatColor.GREEN + "You have successfully set the protection level to, " + ylevel);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Too many arguments!");
            }

        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to run that command!");
        }

        return false;
    }
}
