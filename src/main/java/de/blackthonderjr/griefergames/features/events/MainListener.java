package de.blackthonderjr.griefergames.features.events;

import com.earth2me.essentials.Essentials;
import de.blackthonderjr.griefergames.features.Main;
import net.ess3.api.MaxMoneyException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.K;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MainListener implements Listener {
    @EventHandler
    public void onPerkInv(InventoryClickEvent e) throws MaxMoneyException, IOException {
        Player player = (Player) e.getWhoClicked();
        Essentials ess = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
        File Perk = new File("plugins/GrieferGames/Data/Perk.yml");
        String Prefix = Main.getInstance().getConfig().getString("PerkPrefix").replace("&", "§");
        String NoPerms = Main.getInstance().getConfig().getString("NoPerms").replace("&", "§");
        YamlConfiguration yPerk = YamlConfiguration.loadConfiguration(Perk);
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
        Integer money = Integer.valueOf(ess.getUser(player).getMoney().intValue());
        if (!(e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("fill"))) {
            if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Nofall")) {
                if (yPerk.getString(player.getUniqueId() + ".NoFall") == null) {
                    if (!(money < NoFall)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - NoFall);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6NoFall§a-Perk für §2"+ NoFall +" gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".NoFall", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".NoFall") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6NoFall§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".NoFall", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".NoFall") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6NoFall§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".NoFall", true);

                    yPerk.save(Perk);

                }
            } else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Clearchat")) {
                if (yPerk.getString(player.getUniqueId() + ".Clearchat") == null) {
                    if (!(money < ClearChatPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - ClearChatPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6NoFall§a-Perk für §2"+ ClearChatPerk +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Clearchat", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Clearchat") == true) {

                    player.closeInventory();

                }
            } else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Startkick")) {
                if (yPerk.getString(player.getUniqueId() + ".Startkick") == null) {
                    if (!(money < StartKickPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - StartKickPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6StartKick§a-Perk für §2"+ StartKickPerk +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Startkick", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Startkick") == true) {

                    e.setCancelled(true);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Slowchat")) {
                if (yPerk.getString(player.getUniqueId() + ".Slowchat") == null) {
                    if (!(money < SlowChatPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - SlowChatPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6SlowChat§a-Perk für §2"+ SlowChatPerk +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Slowchat", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Slowchat") == true) {

                    e.setCancelled(true);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Mutep")) {
                if (yPerk.getString(player.getUniqueId() + ".Mutep") == null) {
                    if (!(money < MutepPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - MutepPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6MuteP§a-Perk für §2" + MutepPerk + " §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Mutep", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Mutep") == true) {

                    e.setCancelled(true);


                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Nohunger")) {
                if (yPerk.getString(player.getUniqueId() + ".Nohunger") == null) {
                    if (!(money < NoHunger)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - NoHunger);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6NoHunger§a-Perk für §2"+ NoHunger +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Nohunger", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Nohunger") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6NoHunger§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Nohunger", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Nohunger") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6NoHunger§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Nohunger", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Sprungkraft")) {
                if (yPerk.getString(player.getUniqueId() + ".Sprungkraft") == null) {
                    if (!(money < Sprungkraft)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Sprungkraft);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6Sprungkraft§a-Perk für §2"+ Sprungkraft +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Sprungkraft", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Sprungkraft") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Sprungkraft§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Sprungkraft", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Sprungkraft") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Sprungkraft§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Sprungkraft", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Stärke")) {
                if (yPerk.getString(player.getUniqueId() + ".Stärke") == null) {
                    if (!(money < Stärke)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Stärke);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6Stärke§a-Perk für §2"+ Stärke +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Stärke", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Stärke") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Stärke§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Stärke", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Stärke") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Stärke§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Stärke", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Unterwasseratmung")) {
                if (yPerk.getString(player.getUniqueId() + ".Unterwasseratmung") == null) {
                    if (!(money < Unterwasseratmung)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Unterwasseratmung);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6Unterwasseratmung§a-Perk für §2"+ Unterwasseratmung +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Unterwasseratmung", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Unterwasseratmung") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Unterwasseratmung§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Unterwasseratmung", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Unterwasseratmung") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Unterwasseratmung§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Unterwasseratmung", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Feuerresistenz")) {
                if (yPerk.getString(player.getUniqueId() + ".Feuerresistenz") == null) {
                    if (!(money < Feuerresistanz)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Feuerresistanz);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6Feuerresistenz§a-Perk für §2"+ Feuerresistanz +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Feuerresistenz", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Feuerresistenz") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Feuerresistenz§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Feuerresistenz", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Feuerresistenz") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Feuerresistenz§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Feuerresistenz", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Schnelligkeit")) {
                if (yPerk.getString(player.getUniqueId() + ".Schnelligkeit") == null) {
                    if (!(money < Schnelligkeit)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Schnelligkeit);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6Schnelligkeit§a-Perk für §2"+ Schnelligkeit +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Schnelligkeit", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Schnelligkeit") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Schnelligkeit§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Schnelligkeit", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Schnelligkeit") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Schnelligkeit§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Schnelligkeit", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Keephotbar")) {
                if (yPerk.getString(player.getUniqueId() + ".Keephotbar") == null) {
                    if (!(money < KeepHotbar)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - KeepHotbar);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6KeepHotbar§a-Perk für §2"+ KeepHotbar +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Keephotbar", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Keephotbar") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6KeepHotbar§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Keephotbar", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Keephotbar") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6KeepHotbar§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Keephotbar", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Keepxp")) {
                if (yPerk.getString(player.getUniqueId() + ".Keepxp") == null) {
                    if (!(money < KeepXP)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - KeepXP);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6KeepXP§a-Perk für §2"+ KeepXP +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Keepxp", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Keepxp") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6KeepXP§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Keepxp", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Keepxp") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6KeepXP§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Keepxp", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Doppeltexp")) {
                if (yPerk.getString(player.getUniqueId() + ".Doppeltexp") == null) {
                    if (!(money < DoppelteXP)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - DoppelteXP);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6Doppelte XP§a-Perk für §2"+ DoppelteXP +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Doppeltexp", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Doppeltexp") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Doppelte XP§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Doppeltexp", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Doppeltexp") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Doppelte XP§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Doppeltexp", true);

                    yPerk.save(Perk);

                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Nachtsicht")) {
                if (yPerk.getString(player.getUniqueId() + ".Nachtsicht") == null) {
                    if (!(money < Nachtsicht)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Nachtsicht);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§aDu hast das §6Nachtsicht§a-Perk für §2"+ Nachtsicht +" §agekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Nachtsicht", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }else if(yPerk.getBoolean(player.getUniqueId() + ".Nachtsicht") == true) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Nachtsicht§7-Perk §cdeaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Nachtsicht", false);

                    yPerk.save(Perk);

                } else if(yPerk.getBoolean(player.getUniqueId() + ".Nachtsicht") == false) {

                    player.closeInventory();
                    player.sendMessage(Prefix + "§7Du hast das §6Nachtsicht§7-Perk §aaktiviert§7!");

                    yPerk.set(player.getUniqueId() + ".Nachtsicht", true);

                    yPerk.save(Perk);

                }else {
                    e.setCancelled(true);
                }
            }else if(e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("deaktiviert")){
                e.setCancelled(true);
            }else if(e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("aktiviert")){
                e.setCancelled(true);
            }else if(e.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("fill")){
                e.setCancelled(true);
            }else{
                e.setCancelled(true);
            }
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        if(e.getEntity() instanceof Player) {

            Player p = (Player) e.getEntity();

            File Perk = new File("plugins/GrieferGames/Data/Perk.yml");
            YamlConfiguration yPerk = YamlConfiguration.loadConfiguration(Perk);

            if(yPerk.getString(p.getUniqueId() + ".NoHunger") != null) {
                if(yPerk.getBoolean(p.getUniqueId() + ".NoHunger") == true) {

                    e.setFoodLevel(20);

                }
            }
        }
    }

    @EventHandler
    public void onFallDMG(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {

            Player p = (Player) e.getEntity();

            if(e.getCause() == EntityDamageEvent.DamageCause.FALL) {

                File Perk = new File("plugins/GrieferGames/Data/Perk.yml");
                YamlConfiguration yPerk = YamlConfiguration.loadConfiguration(Perk);

                if(yPerk.getString(p.getUniqueId() + ".NoFall") != null) {
                    if(yPerk.getBoolean(p.getUniqueId() + ".NoFall") == true) {

                        e.setCancelled(true);

                    }
                }
            }
        }
    }
    @EventHandler
    public void onJailObisianBreak(BlockBreakEvent e) throws IOException {
        Player player = e.getPlayer();
        File Jail = new File("plugins/GrieferGames/Data/Jail.yml");
        YamlConfiguration yJail = YamlConfiguration.loadConfiguration(Jail);
        Boolean PlayerIsInJail = Boolean.valueOf(yJail.getString(player.getUniqueId().toString()));
        Boolean TeamJail = Boolean.valueOf(yJail.getString(player.getUniqueId().toString() + ".wasTeam"));
        int TeamObsidian = Integer.parseInt(yJail.getString(player.getUniqueId().toString() + ".getTeamObsidian"));
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        int ObsidianBreaks = Integer.parseInt(yJail.getString(player.getUniqueId().toString() + ".getObsidianBreaks"));
        if(PlayerIsInJail){
            if(TeamJail){
                if(yJail.getString(player.getUniqueId().toString() + ".getTeamObsidian") != null && ObsidianBreaks < TeamObsidian){
                    ObsidianBreaks++;
                    yJail.set(player.getUniqueId().toString() + ".getObsidianBreaks", ObsidianBreaks);
                    yJail.save(Jail);
                }else if(yJail.getString(player.getUniqueId().toString() + ".getTeamObsidian") != null && ObsidianBreaks == TeamObsidian){
                    yJail.set(player.getUniqueId().toString(), false);
                    yJail.save(Jail);
                }
            }else{
                if(ObsidianBreaks < 15){
                    ObsidianBreaks++;
                    yJail.set(player.getUniqueId().toString() + ".getObsidianBreaks", ObsidianBreaks);
                    yJail.save(Jail);
                }else if(ObsidianBreaks == 15){
                    yJail.set(player.getUniqueId().toString(), false);
                    yJail.save(Jail);
                }
            }
            final Runnable runnable = new Runnable() {
                int countdownStarter = 300;

                public void run() {

                    System.out.println(countdownStarter);
                    countdownStarter--;

                    if (countdownStarter < 0) {
                        e.setCancelled(true);
                        scheduler.shutdown();
                    }
                }
            };
            scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
        }
    }
}