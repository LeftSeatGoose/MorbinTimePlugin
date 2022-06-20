package org.morbin.morbintimeplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MorbinTimePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("kit").setExecutor(new CommandKit());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
