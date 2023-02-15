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
            if (e.getCurrentItem().getItemMeta().getLocalizedName() == "nofall") {
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
            } else {
                e.setCancelled(true);
            }
        }
    }
}
