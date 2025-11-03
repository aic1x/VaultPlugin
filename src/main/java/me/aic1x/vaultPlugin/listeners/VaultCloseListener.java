package me.aic1x.vaultPlugin.listeners;

import me.aic1x.vaultPlugin.data.Vault;
import me.aic1x.vaultPlugin.data.VaultManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VaultCloseListener implements Listener {

    private final VaultManager vaultManager;

    public VaultCloseListener(VaultManager vaultManager) {
        this.vaultManager = vaultManager;
    }

    @EventHandler
    public void vaultClose(org.bukkit.event.inventory.InventoryCloseEvent e){
        if (e.getInventory().getHolder() instanceof Vault){
            Vault v = (Vault)e.getInventory().getHolder();
            vaultManager.saveVault(e.getPlayer().getUniqueId(), v);
        }
    }
}
