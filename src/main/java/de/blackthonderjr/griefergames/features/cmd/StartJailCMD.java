package de.blackthonderjr.griefergames.features.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class StartJailCMD implements CommandExecutor {
    File Jail = new File("plugins/GrieferGames/Data/Jail.yml");
    YamlConfiguration yJail = YamlConfiguration.loadConfiguration(Jail);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Boolean PlayerIsInJail = Boolean.valueOf(yJail.getString(player.getUniqueId().toString()));
        Location location = new Location(Bukkit.getWorld("world"),0.0,64.0,0.0);
        player.teleport(location);
        yJail.set(player.getUniqueId().toString(), true);
        return false;
    }
}
