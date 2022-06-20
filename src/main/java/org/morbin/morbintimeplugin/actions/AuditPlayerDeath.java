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

        for(int i = 0; i < event.getEntity().getPlayer().getInventory().getExtraContents().length; i++) {
            ItemStack stack = event.getEntity().getPlayer().getInventory().getExtraContents()[i];
            if(stack == null) {
                continue;
            }

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

        for(int i = 0; i < event.getEntity().getPlayer().getInventory().getArmorContents().length; i++) {
            ItemStack stack = event.getEntity().getPlayer().getInventory().getArmorContents()[i];
            if(stack == null) {
                continue;
            }

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

        ItemStack main_hand = event.getEntity().getPlayer().getInventory().getItemInMainHand();
        boolean keep_main_hand = false;
        for (Material element : Constants.INDESTRUCTIBLE_ITEMS) {

            if (main_hand.getType().equals(element)) {
                keep_main_hand = true;
                break;
            }
        }
        if(!keep_main_hand)
            main_hand.setAmount(0);

        ItemStack off_hand = event.getEntity().getPlayer().getInventory().getItemInOffHand();
        boolean keep_off_hand = false;
        for (Material element : Constants.INDESTRUCTIBLE_ITEMS) {

            if (off_hand.getType().equals(element)) {
                keep_off_hand = true;
                break;
            }
        }
        if(!keep_off_hand)
            off_hand.setAmount(0);
    }
}
