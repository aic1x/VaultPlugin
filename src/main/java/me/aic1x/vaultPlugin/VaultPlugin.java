package me.aic1x.vaultPlugin;

import me.aic1x.vaultPlugin.commands.openVault;
import me.aic1x.vaultPlugin.data.VaultManager;
import me.aic1x.vaultPlugin.listeners.VaultCloseListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaultPlugin extends JavaPlugin {
    private VaultManager vaultManager;

    @Override
    public void onEnable() {
        vaultManager = new VaultManager(this);
        vaultManager.loadVaults();

        getCommand("vault").setExecutor(new openVault(vaultManager));
        getServer().getPluginManager().registerEvents(new VaultCloseListener(vaultManager), this);

    }

    @Override
    public void onDisable() {
        vaultManager.saveVaults();

    }
}
