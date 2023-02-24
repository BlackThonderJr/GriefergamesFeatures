package de.blackthonderjr.griefergames.features;

import de.blackthonderjr.griefergames.features.cmd.GGRLCMD;
import de.blackthonderjr.griefergames.features.cmd.PerkCMD;
import de.blackthonderjr.griefergames.features.cmd.StartJailCMD;
import de.blackthonderjr.griefergames.features.events.MainListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public static void reload() {
        Bukkit.getPluginManager().getPlugin("GriefergamesFeatures").getConfig();
        Bukkit.getPluginManager().getPlugin("GriefergamesFeatures").reloadConfig();
    }

    @Override
    public void onEnable() {
        instance = this;
        config();
        getCommand("perks").setExecutor(new PerkCMD());
        Bukkit.getPluginManager().registerEvents(new MainListener(), this);
        getCommand("ggrl").setExecutor(new GGRLCMD());
        getCommand("startjail").setExecutor(new StartJailCMD());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void config(){
        getConfig().addDefault("PerkPrefix", "&8[§6Perks§8] §r");
        getConfig().addDefault("NoFallPerk", 500000);
        getConfig().addDefault("ClearChatPerk", 400000);
        getConfig().addDefault("StartKickPerk", 1500000);
        getConfig().addDefault("SlowChatPerk", 500000);
        getConfig().addDefault("MutepPerk", 2000000);
        getConfig().addDefault("NoHungerPerk", 250000);
        getConfig().addDefault("SprungkraftPerk", 250000);
        getConfig().addDefault("StärkePerk", 400000);
        getConfig().addDefault("UnterwasseratmungPerk", 250000);
        getConfig().addDefault("FeuerresistanzPerk", 500000);
        getConfig().addDefault("SchnelligkeitPerk", 250000);
        getConfig().addDefault("KeepHotbarPerk", 1000000);
        getConfig().addDefault("KeepXPPerk", 500000);
        getConfig().addDefault("DoppelteXPPerk", 500000);
        getConfig().addDefault("NachtsichtPerk", 250000);
        FileConfiguration cfg = getConfig();
        cfg.options().copyDefaults(true);
        saveConfig();
    }
}
