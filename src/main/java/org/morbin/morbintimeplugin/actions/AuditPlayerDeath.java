package org.morbin.morbintimeplugin.actions;

import org.bukkit.Material;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.morbin.morbintimeplugin.Constants;

public class AuditPlayerDeath {
    public void environmentDeath(PlayerDeathEvent event) {
        for(int i = 0; i < event.getEntity().getPlayer().getInventory().getStorageContents().length; i++) {
            ItemStack stack = event.getEntity().getPlayer().getInventory().getStorageContents()[i];
            if(stack == null) {
                continue;
            }

            auditStack(stack);
        }

        for(int i = 0; i < event.getEntity().getPlayer().getInventory().getExtraContents().length; i++) {
            ItemStack stack = event.getEntity().getPlayer().getInventory().getExtraContents()[i];
            if(stack == null) {
                continue;
            }

            auditStack(stack);
        }

        for(int i = 0; i < event.getEntity().getPlayer().getInventory().getArmorContents().length; i++) {
            ItemStack stack = event.getEntity().getPlayer().getInventory().getArmorContents()[i];
            if(stack == null) {
                continue;
            }

            auditStack(stack);
        }

        auditStack(event.getEntity().getPlayer().getInventory().getItemInMainHand());
        auditStack(event.getEntity().getPlayer().getInventory().getItemInOffHand());
    }

    public void auditStack(ItemStack stack) {
        boolean indestructible = false;
        for (Material element : Constants.INDESTRUCTIBLE_ITEMS) {
            if (stack.getType().equals(element)) {
                indestructible = true;
                break;
            }
        }

        if(!indestructible)
            stack.setAmount(0);
    }
}
