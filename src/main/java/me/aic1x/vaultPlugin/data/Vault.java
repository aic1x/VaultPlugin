package me.aic1x.vaultPlugin.data;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.UUID;

public class Vault implements InventoryHolder {
    UUID uuid;
    public Inventory inv;

    public Vault(UUID uuid){
        this.uuid = uuid;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
