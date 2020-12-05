package com.soulcraftserver.voidprotection;

import com.soulcraftserver.voidprotection.commands.SetProtectionLevel;
import com.soulcraftserver.voidprotection.commands.SetTPLocation;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register Events
        getServer().getPluginManager().registerEvents(new Listener(this), this);

        // Config
        getConfig().options().copyDefaults(true);
        saveConfig();

        if(getConfig().get("protectionlevel") == null) {
            getConfig().set("protectionlevel", 0);
            saveConfig();
        }

        // Register Commands
        getCommand("setprotectionlevel").setExecutor(new SetProtectionLevel(this));
        getCommand("settplocation").setExecutor(new SetTPLocation(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
