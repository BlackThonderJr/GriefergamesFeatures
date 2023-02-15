package de.blackthonderjr.griefergames.features.cmd;

import com.sun.tools.javac.jvm.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class PerkCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Inventory inv = Bukkit.createInventory(null,54, "§6Perks");
        int i;
        int slots = 54;
        ItemStack fillitem = new ItemStack(Material.GRAY_STAINED_GLASS);
        ItemMeta fillmeta = fillitem.getItemMeta();
        fillmeta.setDisplayName("§´");
        fillmeta.setLocalizedName("fill");
        fillitem.setItemMeta(fillmeta);

        ItemStack nofallitem = new ItemStack(Material.GRAY_STAINED_GLASS);
        ItemMeta nofallmeta = nofallitem.getItemMeta();
        nofallmeta.setDisplayName("§´");
        nofallmeta.setLocalizedName("nofall");
        nofallitem.setItemMeta(fillmeta);




        for(i = 0; i < slots; i++){
            if(inv.getItem(i) == null) {
                inv.setItem(i, fillitem);
            }
        }
        return false;
    }
}
