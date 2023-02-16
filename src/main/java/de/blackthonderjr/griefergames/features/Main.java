package de.blackthonderjr.griefergames.features;

import de.blackthonderjr.griefergames.features.cmd.PerkCMD;
import de.blackthonderjr.griefergames.features.events.MainListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getCommand("perks").setExecutor(new PerkCMD());
        Bukkit.getPluginManager().registerEvents(new MainListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
