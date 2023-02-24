package de.blackthonderjr.griefergames.features.cmd;

import de.blackthonderjr.griefergames.features.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GGRLCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String Prefix = Main.getInstance().getConfig().getString("Prefix").replace("&", "�");
        String NoPerms = Prefix + Main.getInstance().getConfig().getString("NoPerms").replace("&", "�");

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(p.hasPermission("System.reload")) {

                Main.reload();

                p.sendMessage(Prefix + "�7Die Config wurde erfolgreich reloadet!");

            } else {
                p.sendMessage(NoPerms);
            }
        } else {

            Main.reload();

            Bukkit.getConsoleSender().sendMessage(Prefix + "�7Die Config wurde erfolgreich reloadet!");

        }
        return true;
    }
}
