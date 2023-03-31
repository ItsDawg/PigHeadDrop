package me.dawg.pigheaddrop;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class PigHeadDrop extends JavaPlugin implements @NotNull Listener {

    @Override
    public void onEnable() {
        getLogger().info("PigHeadDrop has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public @NotNull ComponentLogger getComponentLogger() {
        return super.getComponentLogger();
    }

    @Override
    public void onDisable() {
        getLogger().info("PigHeadDrop has been disabled!");
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if(event.getEntityType() == EntityType.PIG) {
            Pig pig = (Pig) event.getEntity();
            pig.getWorld().dropItemNaturally(pig.getLocation(), getPigHeadItem());
        }
    }

    private ItemStack getPigHeadItem() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner("MHF_Pig");
        meta.setDisplayName("Pig Head");
        item.setItemMeta(meta);
        return item;
    }
}
