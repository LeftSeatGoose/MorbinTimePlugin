package org.morbin.morbintimeplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MorbinTimePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
