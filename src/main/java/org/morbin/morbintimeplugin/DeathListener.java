package org.morbin.morbintimeplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.morbin.morbintimeplugin.actions.AuditPlayerDeath;

public class DeathListener implements Listener {

    // test for totem
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        AuditPlayerDeath auditor = new AuditPlayerDeath();

        if(event.getEntity().getKiller() == null) {
            auditor.environmentDeath(event);
        }

        event.setDeathMessage("Someone got morbed...");
    }
}
