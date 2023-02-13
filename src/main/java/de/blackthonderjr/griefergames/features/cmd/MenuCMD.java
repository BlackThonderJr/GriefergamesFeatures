package de.latemoon.blackthonderjr.lmfeatures.cmds;

import de.latemoon.blackthonderjr.lmfeatures.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class MenuCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        int i;
        int slots = 45;
        Inventory inv = Bukkit.createInventory(null,slots,"");
        ItemStack fillitem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack PVPtrue = new ItemStack(Material.COAL);
        ItemStack PVPfalse = new ItemStack(Material.COAL);
        ItemStack  = new ItemStack(Material.COAL);
        ItemStack Coal = new ItemStack(Material.COAL);







        inv.setItem(4,Coal);
        for(i = 0; i < slots; i++){
            if(inv.getItem(i) == null) {
                inv.setItem(i, fillitem);
            }
        }
        Player player = (Player)sender;
        player.openInventory(inv);
        return false;
    }
}
