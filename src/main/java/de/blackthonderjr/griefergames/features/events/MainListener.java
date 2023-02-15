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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.K;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class MainListener implements Listener {
    @EventHandler
    public void onPerkInv(InventoryClickEvent e) throws MaxMoneyException, IOException {
        Player player = (Player) e.getWhoClicked();
        Essentials ess = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
        File Perk = new File("plugins/GrieferGames/Data/Perk.yml");
        String Prefix = Main.getInstance().getConfig().getString("Prefix").replace("&", "§");
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
        if (e.getCurrentItem().getItemMeta().getLocalizedName() != "fill") {
            if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Nofall") {
                if (yPerk.getString(player.getUniqueId() + ".NoFall") == null) {
                    if (!(money < NoFall)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - NoFall);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das NoFall-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".NoFall", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            } else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Clearchat") {
                if (yPerk.getString(player.getUniqueId() + ".Clearchat") == null) {
                    if (!(money < ClearChatPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - ClearChatPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das ClearChat-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Clearchat", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            } else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Startkick") {
                if (yPerk.getString(player.getUniqueId() + ".Startkick") == null) {
                    if (!(money < StartKickPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - StartKickPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das StartKick-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Startkick", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Slowchat") {
                if (yPerk.getString(player.getUniqueId() + ".Slowchat") == null) {
                    if (!(money < SlowChatPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - SlowChatPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das SlowChat-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Slowchat", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Mutep") {
                if (yPerk.getString(player.getUniqueId() + ".Mutep") == null) {
                    if (!(money < MutepPerk)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - MutepPerk);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Mutep-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Mutep", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Nohunger") {
                if (yPerk.getString(player.getUniqueId() + ".Nohunger") == null) {
                    if (!(money < NoHunger)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - NoHunger);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das NoHunger-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Nohunger", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Sprungkraft") {
                if (yPerk.getString(player.getUniqueId() + ".Sprungkraft") == null) {
                    if (!(money < Sprungkraft)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Sprungkraft);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Sprungkraft-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Sprungkraft", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Stärke") {
                if (yPerk.getString(player.getUniqueId() + ".Stärke") == null) {
                    if (!(money < Stärke)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Stärke);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Stärke-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Stärke", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Unterwasseratmung") {
                if (yPerk.getString(player.getUniqueId() + ".Unterwasseratmung") == null) {
                    if (!(money < Unterwasseratmung)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Unterwasseratmung);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Unterwasseratmung-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Unterwasseratmung", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Feuerresistenz") {
                if (yPerk.getString(player.getUniqueId() + ".Feuerresistenz") == null) {
                    if (!(money < Feuerresistanz)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Feuerresistanz);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Feuerresistenz-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Feuerresistenz", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Schnelligkeit") {
                if (yPerk.getString(player.getUniqueId() + ".Schnelligkeit") == null) {
                    if (!(money < Schnelligkeit)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Schnelligkeit);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Schnelligkeit-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Schnelligkeit", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Keephotbar") {
                if (yPerk.getString(player.getUniqueId() + ".Keephotbar") == null) {
                    if (!(money < KeepHotbar)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - KeepHotbar);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das KeepHotbar-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Keephotbar", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Keepxp") {
                if (yPerk.getString(player.getUniqueId() + ".Keepxp") == null) {
                    if (!(money < KeepXP)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - KeepXP);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das KeepXP-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Keepxp", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Doppeltexp") {
                if (yPerk.getString(player.getUniqueId() + ".Doppeltexp") == null) {
                    if (!(money < DoppelteXP)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - DoppelteXP);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Doppelte XP-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Doppeltexp", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }else if (e.getCurrentItem().getItemMeta().getLocalizedName() == "Nachtsicht") {
                if (yPerk.getString(player.getUniqueId() + ".Nachtsicht") == null) {
                    if (!(money < Nachtsicht)) {
                        BigDecimal neuesgeld = BigDecimal.valueOf(money - Nachtsicht);
                        player.closeInventory();
                        player.sendMessage(Prefix + "§a§lDu hast das Nachtsicht-Perk gekauft!");
                        ess.getUser(player).setMoney(neuesgeld);
                        yPerk.set(player.getUniqueId() + ".Nachtsicht", true);
                        yPerk.save(Perk);

                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix + "§cDu hast leider nicht genügend Geld!");
                    }
                }
            }
        }
    }
}
