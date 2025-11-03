package me.aic1x.vaultPlugin.commands;

import me.aic1x.vaultPlugin.data.Vault;
import me.aic1x.vaultPlugin.data.VaultManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class openVault implements CommandExecutor {
    private final VaultManager vaultManager;

    public openVault(VaultManager vaultManager) {
        this.vaultManager = vaultManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p){
            Vault v = vaultManager.openVault(p.getUniqueId());
            p.openInventory(v.inv);







        }

        return true;
    }
}
