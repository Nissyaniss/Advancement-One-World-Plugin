package me.nissya.advancementoneworld;

import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public final class AdvancementOneWorld extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Advancement One World Enabled!");
        getServer().getPluginManager().registerEvents(this, this );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {
        Player player = event.getPlayer();
        String world = player.getWorld().getName();

        if (!(world.equals("Survie")) && !(world.equals("Survie_End")) && !(world.equals("Survie_Nether"))) {
            Advancement advancement = event.getAdvancement();
            Iterator<String> i = advancement.getCriteria().iterator();

            while (i.hasNext()) {
                String criteria = (String)i.next();
                player.getAdvancementProgress(advancement).revokeCriteria(criteria);
            }
        }
    }
}
