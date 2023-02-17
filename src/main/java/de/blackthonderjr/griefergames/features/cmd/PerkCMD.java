package de.blackthonderjr.griefergames.features.cmd;

import com.sun.tools.javac.jvm.Items;
import de.blackthonderjr.griefergames.features.ItemBuilder;
import de.blackthonderjr.griefergames.features.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerkCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ArrayList<String> on = new ArrayList<>();
        ArrayList<String> off = new ArrayList<>();
        ArrayList<String> nofall = new ArrayList<>();
        ArrayList<String> clearchat = new ArrayList<>();
        ArrayList<String> startkick = new ArrayList<>();
        ArrayList<String> slowchat = new ArrayList<>();
        ArrayList<String> mutep = new ArrayList<>();
        ArrayList<String> nohunger = new ArrayList<>();
        ArrayList<String> keepinv = new ArrayList<>();
        ArrayList<String> keepxp = new ArrayList<>();
        ArrayList<String> doppeltxp = new ArrayList<>();
        ArrayList<String> nachtsicht = new ArrayList<>();
        ArrayList<String> speed = new ArrayList<>();
        ArrayList<String> feuer = new ArrayList<>();
        ArrayList<String> wasser = new ArrayList<>();
        ArrayList<String> stärke = new ArrayList<>();
        ArrayList<String> jump = new ArrayList<>();

        File Perk = new File("plugins/GrieferGames/Data/Perk.yml");
        YamlConfiguration yPerk = YamlConfiguration.loadConfiguration(Perk);


        Inventory inv = Bukkit.createInventory(null,54, "§6Perks");

        Integer NoFall = Main.getInstance().getConfig().getInt("NoFallPerk");
        Integer NoHunger = Main.getInstance().getConfig().getInt("NoHungerPerk");
        Integer MutepPerk = Main.getInstance().getConfig().getInt("MutepPerk");
        Integer ClearChatPerk = Main.getInstance().getConfig().getInt("ClearChatPerk");
        Integer SlowChatPerk = Main.getInstance().getConfig().getInt("SlowChatPerk");
        Integer StartKickPerk = Main.getInstance().getConfig().getInt("StartKickPerk");
        Integer Sprungkraft = Main.getInstance().getConfig().getInt("SprungkraftPerk");
        Integer Stärke = Main.getInstance().getConfig().getInt("StärkePerk");
        Integer Unterwasseratmung = Main.getInstance().getConfig().getInt("UnterwasseratmungPerk");
        Integer Feuerresistanz = Main.getInstance().getConfig().getInt("FeuerresistanzPerk");
        Integer Schnelligkeit = Main.getInstance().getConfig().getInt("SchnelligkeitPerk");
        Integer KeepHotbar = Main.getInstance().getConfig().getInt("KeepHotbarPerk");
        Integer KeepXP = Main.getInstance().getConfig().getInt("KeepXPPerk");
        Integer DoppelteXP = Main.getInstance().getConfig().getInt("DoppelteXPPerk");
        Integer Nachtsicht = Main.getInstance().getConfig().getInt("NachtsichtPerk");


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
        nofall.add("§7Wenn du dieses Perk besitzt, bekommst du\nkeinen Fallschaden mehr,\nKosten: " + NoFall);
        nofallmeta.setLore(nofall);
        nofallitem.setItemMeta(nofallmeta);

        ItemStack clearchatitem = new ItemStack(Material.PAPER);
        ItemMeta clearchatmeta = clearchatitem.getItemMeta();
        clearchatmeta.setDisplayName("§6ClearChat-Befehl");
        clearchatmeta.setLocalizedName("Clearchat");
        clearchat.add("§7Wenn du dieses Perk besitzt, kannst du den Befehl\n§e/clearchat §7benutzen, um den Chat zu leeren.\nKosten: " + ClearChatPerk);
        clearchatmeta.setLore(clearchat);
        clearchatitem.setItemMeta(clearchatmeta);

        ItemStack startkickitem = new ItemStack(Material.OAK_SIGN);
        ItemMeta startkickmeta = startkickitem.getItemMeta();
        startkickmeta.setDisplayName("§6Startkick-Befehl");
        startkickmeta.setLocalizedName("Startkick");
        startkick.add("§7Wenn du dieses Perk besitzt, kannst du den Befehl\n§e/startkick §7benutzen, um eine Abstimmung für einen Rauswurf zu starten.\nKosten: " + StartKickPerk);
        startkickmeta.setLore(startkick);
        startkickitem.setItemMeta(startkickmeta);

        ItemStack slowchatitem = new ItemStack(Material.SOUL_SAND);
        ItemMeta slowchatmeta = slowchatitem.getItemMeta();
        slowchatmeta.setDisplayName("§6Slowchat-Befehl");
        slowchatmeta.setLocalizedName("Slowchat");
        slowchat.add("§7Wenn du dieses Perk besitzt, kannst du den Befehl\n§e/slowchat §7benutzen, um den Chat zu verlangsamen.\nKosten: " + SlowChatPerk);
        slowchatmeta.setLore(slowchat);
        slowchatitem.setItemMeta(slowchatmeta);

        ItemStack mutepitem = new ItemStack(Material.BARRIER);
        ItemMeta mutepmeta = mutepitem.getItemMeta();
        mutepmeta.setDisplayName("§6MuteP-Befehl");
        mutepmeta.setLocalizedName("Mutep");
        mutep.add("§7Wenn du dieses Perk besitzt, kannst du den Befehl\n§e/mutep §7benutzen, um einen Spieler für 15 Minuten zu muten.\nKosten: " + MutepPerk);
        mutepmeta.setLore(slowchat);
        mutepitem.setItemMeta(mutepmeta);

        ItemStack nohungeritem = new ItemStack(Material.COOKED_BEEF);
        ItemMeta nohungermeta = nohungeritem.getItemMeta();
        nohungermeta.setDisplayName("§6Kein Hunger");
        nohungermeta.setLocalizedName("Nohunger");
        nohunger.add("§7Wenn du dieses Perk besitzt, bekommst du\nkeinen Hunger mehr.\nKosten: " + NoHunger);
        nohungermeta.setLore(nohunger);
        nohungeritem.setItemMeta(nohungermeta);

        ItemStack keephotbaritem = new ItemStack(Material.CHEST);
        ItemMeta keephotbarmeta = keephotbaritem.getItemMeta();
        keephotbarmeta.setDisplayName("§6KeepHotbar");
        keepinv.add("§7Wenn du dieses Perk besitzt, verlierst du\nbeim Tod deine Hotbar nicht mehr.\nKosten: " + KeepHotbar);
        keephotbarmeta.setLore(keepinv);
        keephotbarmeta.setLocalizedName("Keephotbar");
        keephotbaritem.setItemMeta(keephotbarmeta);

        ItemStack keepxpitem = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta keepxpmeta = keepxpitem.getItemMeta();
        keepxpmeta.setDisplayName("§6KeepXP");
        keepxp.add("§7Wenn du dieses Perk besitzt, verlierst du\nbeim Tod deine Erfahrungspunkte nicht mehr.\nKosten: " + KeepXP);
        keepxpmeta.setLore(keepxp);
        keepxpmeta.setLocalizedName("Keepxp");
        keepxpitem.setItemMeta(keepxpmeta);

        ItemStack doppeltexpitem = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta doppeltexpmeta = doppeltexpitem.getItemMeta();
        doppeltexpmeta.setDisplayName("§6Doppelte XP");
        doppeltexpmeta.setLocalizedName("Doppeltexp");
        doppeltxp.add("§7Wenn du dieses Perk besitzt, bekommst du\nimmer die doppelten Erfahrungspunkte.\nKosten: " + DoppelteXP);
        doppeltexpmeta.setLore(doppeltxp);
        doppeltexpitem.setItemMeta(doppeltexpmeta);

        ItemStack nachtsichtitem = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta nachtsichtmeta = nachtsichtitem.getItemMeta();
        nachtsichtmeta.setDisplayName("§6Nachtsicht+");
        nachtsichtmeta.setLocalizedName("Nachtsicht");
        nachtsicht.add("§7Wenn du dieses Perk besitzt, hast du\neinen dauerhaften Nachtsicht-Effekt.\nKosten: " + Nachtsicht);
        nachtsichtmeta.setLore(nachtsicht);
        nachtsichtitem.setItemMeta(nachtsichtmeta);


        ItemStack jumpitem = new ItemStack(Material.POTION);
        PotionMeta jumpmeta = (PotionMeta) jumpitem.getItemMeta();
        jumpmeta.setMainEffect(PotionEffectType.JUMP);
        jumpmeta.setDisplayName("§6Sprungkraft+");
        jumpmeta.setLocalizedName("Sprungkraft");
        jump.add("Wenn du dieses Perk besitzt, bekommst du\neinen dauerhaften Sprungkraft-Effekt.\nKosten: " + Sprungkraft);
        jumpmeta.setLore(jump);
        jumpitem.setItemMeta(jumpmeta);

        ItemStack strengthitem = new ItemStack(Material.POTION);
        PotionMeta strengthmeta = (PotionMeta) strengthitem.getItemMeta();
        strengthmeta.setMainEffect(PotionEffectType.INCREASE_DAMAGE);
        strengthmeta.setDisplayName("§6Stärke+");
        stärke.add("Wenn du dieses Perk besitzt, bekommst du\neinen dauerhaften Sprungkraft-Effekt.\nKosten: " + Stärke);
        strengthmeta.setLore(stärke);
        strengthmeta.setLocalizedName("Stärke");
        strengthitem.setItemMeta(strengthmeta);

        ItemStack wateritem = new ItemStack(Material.POTION);
        PotionMeta watermeta = (PotionMeta) wateritem.getItemMeta();
        watermeta.setMainEffect(PotionEffectType.WATER_BREATHING);
        watermeta.setDisplayName("§6Unterwasseratmung+");
        wasser.add("Wenn du dieses Perk besitzt, bekommst du\neinen dauerhaften Sprungkraft-Effekt.\nKosten: " + Unterwasseratmung);
        watermeta.setLore(wasser);
        watermeta.setLocalizedName("Unterwasseratmung");
        wateritem.setItemMeta(watermeta);

        ItemStack fireitem = new ItemStack(Material.POTION);
        PotionMeta firemeta = (PotionMeta) fireitem.getItemMeta();
        firemeta.setMainEffect(PotionEffectType.FIRE_RESISTANCE);
        firemeta.setDisplayName("§6Feuerresistenz+");
        feuer.add("Wenn du dieses Perk besitzt, bekommst du\neinen dauerhaften Sprungkraft-Effekt.\nKosten: " + Feuerresistanz);
        firemeta.setLore(feuer);
        firemeta.setLocalizedName("Feuerresistenz");
        fireitem.setItemMeta(firemeta);

        ItemStack speeditem = new ItemStack(Material.POTION);
        PotionMeta speedmeta = (PotionMeta) speeditem.getItemMeta();
        speedmeta.setMainEffect(PotionEffectType.SPEED);
        speed.add("Wenn du dieses Perk besitzt, bekommst du\neinen dauerhaften Sprungkraft-Effekt.\nKosten: " + Schnelligkeit);
        speedmeta.setLore(speed);
        speedmeta.setDisplayName("§6Schnelligkeit+");
        speedmeta.setLocalizedName("Schnelligkeit");
        speeditem.setItemMeta(speedmeta);

        //Aktiviert
        @SuppressWarnings("deprecation")
        ItemStack Aktiviert = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, (short) 10);
        ItemMeta AktiviertM = Aktiviert.getItemMeta();
        AktiviertM.setDisplayName("§aAktiviert");
        on.add("§4Klicke, um das Perk zu deaktiveren.");
        AktiviertM.setLore(on);
        Aktiviert.setItemMeta(AktiviertM);

        //Deaktiviert
        @SuppressWarnings("deprecation")
        ItemStack Deaktiviert = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1, (short) 8);
        ItemMeta DeaktiviertM = Deaktiviert.getItemMeta();
        DeaktiviertM.setDisplayName("§cDeaktiviert");
        off.add("§4Klicke, um das Perk zu aktivieren.");
        AktiviertM.setLore(off);
        Deaktiviert.setItemMeta(DeaktiviertM);
        Player p = (Player)sender;




        inv.setItem(1,nofallitem);
        inv.setItem(2,clearchatitem);
        inv.setItem(3,startkickitem);

        inv.setItem(5,slowchatitem);
        inv.setItem(6,mutepitem);
        inv.setItem(7,nohungeritem);

        inv.setItem(20,speeditem);
        inv.setItem(21,fireitem);
        inv.setItem(22,wateritem);
        inv.setItem(23,strengthitem);
        inv.setItem(24,jumpitem);

        inv.setItem(38,clearchatitem);
        inv.setItem(39,startkickitem);

        inv.setItem(41,slowchatitem);
        inv.setItem(42,mutepitem);






        if(yPerk.getString(p.getUniqueId() + ".NoFall") == null) {
            inv.setItem(10, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".NoFall") == true) {
            inv.setItem(10, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".NoFall") == false) {
            inv.setItem(10, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Clearchat") == null) {
            inv.setItem(11, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Clearchat") == true) {
            inv.setItem(11, Aktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Startkick") == null) {
            inv.setItem(12, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Startkick") == true) {
            inv.setItem(12, Aktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".SlowChat") == null) {
            inv.setItem(14, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".SlowChat") == true) {
            inv.setItem(14, Aktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Mutep") == null) {
            inv.setItem(15, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Mutep") == true) {
            inv.setItem(15, Aktiviert);
        }
        if(yPerk.getString(p.getUniqueId() + ".Nohunger") == null) {
            inv.setItem(16, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Nohunger") == true) {
            inv.setItem(16, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Nohunger") == false) {
            inv.setItem(16, Deaktiviert);
        }
        if(yPerk.getString(p.getUniqueId() + ".Schnelligkeit") == null) {
            inv.setItem(29, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Schnelligkeit") == true) {
            inv.setItem(29, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Schnelligkeit") == false) {
            inv.setItem(29, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Sprungkraft") == null) {
            inv.setItem(33, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Sprungkraft") == true) {
            inv.setItem(33, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Sprungkraft") == false) {
            inv.setItem(33, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Stärke") == null) {
            inv.setItem(32, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Stärke") == true) {
            inv.setItem(32, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Stärke") == false) {
            inv.setItem(32, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Unterwasseratmung") == null) {
            inv.setItem(31, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Unterwasseratmung") == true) {
            inv.setItem(31, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Unterwasseratmung") == false) {
            inv.setItem(31, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Feuerresistenz") == null) {
            inv.setItem(30, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Feuerresistenz") == true) {
            inv.setItem(30, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Feuerresistenz") == false) {
            inv.setItem(30, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Keephotbar") == null) {
            inv.setItem(47, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Keephotbar") == true) {
            inv.setItem(47, Aktiviert);
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Keephotbar") == false) {
            inv.setItem(47, Aktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Keepxp") == null) {
            inv.setItem(48, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Keepxp") == true) {
            inv.setItem(48, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Keepxp") == false) {
            inv.setItem(48, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Doppeltexp") == null) {
            inv.setItem(50, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Doppeltexp") == true) {
            inv.setItem(50, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Doppeltexp") == false) {
            inv.setItem(50, Deaktiviert);
        }

        if(yPerk.getString(p.getUniqueId() + ".Nachtsicht") == null) {
            inv.setItem(51, preis(MutepPerk));
        } else if(yPerk.getBoolean(p.getUniqueId() + ".Nachtsicht") == true) {
            inv.setItem(51, Aktiviert);
        }else if(yPerk.getBoolean(p.getUniqueId() + ".Nachtsicht") == false) {
            inv.setItem(51, Deaktiviert);
        }



        for(i = 0; i < slots; i++){
            if(inv.getItem(i) == null) {
                inv.setItem(i, fillitem);
            }
        }
        Player player = (Player)sender;
        player.openInventory(inv);
        return false;
    }
    public ItemStack preis(Integer Preis) {

        ItemStack i = ItemBuilder.createItemWD(Material.YELLOW_STAINED_GLASS_PANE,"§6Nicht verfügbar",1, new String[]{"§7Kaufe zuerst das Perk, um Einstellungen vornehmen zu können."});

        return i;
    }
}
