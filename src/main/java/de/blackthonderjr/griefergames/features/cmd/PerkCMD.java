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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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

        ItemStack nofallitem = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta nofallmeta = nofallitem.getItemMeta();
        nofallmeta.setDisplayName("§6Kein Fallschaden");
        nofallmeta.setLocalizedName("Nofall");
        nofallitem.setItemMeta(nofallmeta);

        ItemStack clearchatitem = new ItemStack(Material.PAPER);
        ItemMeta clearchatmeta = clearchatitem.getItemMeta();
        clearchatmeta.setDisplayName("§6ClearChat-Befehl");
        clearchatmeta.setLocalizedName("Clearchat");
        clearchatitem.setItemMeta(clearchatmeta);

        ItemStack startkickitem = new ItemStack(Material.OAK_SIGN);
        ItemMeta startkickmeta = startkickitem.getItemMeta();
        startkickmeta.setDisplayName("§6Startkick-Befehl");
        startkickmeta.setLocalizedName("Startkick");
        startkickitem.setItemMeta(startkickmeta);

        ItemStack slowchatitem = new ItemStack(Material.SOUL_SAND);
        ItemMeta slowchatmeta = slowchatitem.getItemMeta();
        slowchatmeta.setDisplayName("§6Slowchat-Befehl");
        slowchatmeta.setLocalizedName("Slowchat");
        slowchatitem.setItemMeta(slowchatmeta);

        ItemStack mutepitem = new ItemStack(Material.BARRIER);
        ItemMeta mutepmeta = mutepitem.getItemMeta();
        mutepmeta.setDisplayName("§6MuteP-Befehl");
        mutepmeta.setLocalizedName("Mutep");
        mutepitem.setItemMeta(mutepmeta);

        ItemStack nohungeritem = new ItemStack(Material.COOKED_BEEF);
        ItemMeta nohungermeta = nohungeritem.getItemMeta();
        nohungermeta.setDisplayName("§6Kein Hunger");
        nohungermeta.setLocalizedName("Nohunger");
        nohungeritem.setItemMeta(nohungermeta);

        ItemStack keephotbaritem = new ItemStack(Material.CHEST);
        ItemMeta keephotbarmeta = keephotbaritem.getItemMeta();
        keephotbarmeta.setDisplayName("§6KeepHotbar");
        keephotbarmeta.setLocalizedName("Keephotbar");
        keephotbaritem.setItemMeta(keephotbarmeta);

        ItemStack keepxpitem = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta keepxpmeta = keepxpitem.getItemMeta();
        keepxpmeta.setDisplayName("§6KeepXP");
        keepxpmeta.setLocalizedName("Keepxp");
        keepxpitem.setItemMeta(keepxpmeta);

        ItemStack doppeltexpitem = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta doppeltexpmeta = doppeltexpitem.getItemMeta();
        doppeltexpmeta.setDisplayName("§6Doppelte XP");
        doppeltexpmeta.setLocalizedName("Doppeltexp");
        doppeltexpitem.setItemMeta(doppeltexpmeta);

        ItemStack nachtsichtitem = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta nachtsichtmeta = nachtsichtitem.getItemMeta();
        nachtsichtmeta.setDisplayName("§6Nachtsicht+");
        nachtsichtmeta.setLocalizedName("Nachtsicht");
        nachtsichtitem.setItemMeta(nachtsichtmeta);


        ItemStack jumpitem = new ItemStack(Material.POTION);
        PotionMeta jumpmeta = (PotionMeta) jumpitem.getItemMeta();
        jumpmeta.setMainEffect(PotionEffectType.JUMP);
        jumpmeta.setDisplayName("§6Sprungkraft+");
        jumpmeta.setLocalizedName("Sprungkraft");
        jumpitem.setItemMeta(jumpmeta);

        ItemStack strengthitem = new ItemStack(Material.POTION);
        PotionMeta strengthmeta = (PotionMeta) strengthitem.getItemMeta();
        strengthmeta.setMainEffect(PotionEffectType.INCREASE_DAMAGE);
        strengthmeta.setDisplayName("§6Stärke+");
        strengthmeta.setLocalizedName("Stärke");
        strengthitem.setItemMeta(strengthmeta);

        ItemStack wateritem = new ItemStack(Material.POTION);
        PotionMeta watermeta = (PotionMeta) wateritem.getItemMeta();
        watermeta.setMainEffect(PotionEffectType.WATER_BREATHING);
        watermeta.setDisplayName("§6Unterwasseratmung+");
        watermeta.setLocalizedName("Unterwasseratmung");
        wateritem.setItemMeta(watermeta);

        ItemStack fireitem = new ItemStack(Material.POTION);
        PotionMeta firemeta = (PotionMeta) fireitem.getItemMeta();
        firemeta.setMainEffect(PotionEffectType.FIRE_RESISTANCE);
        firemeta.setDisplayName("§6Feuerresistenz+");
        firemeta.setLocalizedName("Feuerresistenz");
        fireitem.setItemMeta(firemeta);

        ItemStack speeditem = new ItemStack(Material.POTION);
        PotionMeta speedmeta = (PotionMeta) speeditem.getItemMeta();
        speedmeta.setMainEffect(PotionEffectType.SPEED);
        speedmeta.setDisplayName("§6Schnelligkeit+");
        speedmeta.setLocalizedName("Schnelligkeit");
        speeditem.setItemMeta(speedmeta);

        //Aktiviert
        @SuppressWarnings("deprecation")
        ItemStack Aktiviert = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, (short) 10);
        ItemMeta AktiviertM = Aktiviert.getItemMeta();
        AktiviertM.setDisplayName("§aAktiviert");
        Aktiviert.setItemMeta(AktiviertM);

        //Deaktiviert
        @SuppressWarnings("deprecation")
        ItemStack Deaktiviert = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1, (short) 8);
        ItemMeta DeaktiviertM = Deaktiviert.getItemMeta();
        DeaktiviertM.setDisplayName("§cDeaktiviert");
        Deaktiviert.setItemMeta(DeaktiviertM);

        for(i = 0; i < slots; i++){
            if(inv.getItem(i) == null) {
                inv.setItem(i, fillitem);
            }
        }
        return false;
    }
}
