package me.aic1x.vaultPlugin.data;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VaultManager {
    private final JavaPlugin javaPlugin;

    Map<UUID, Vault> vaults = new HashMap<>();

    public VaultManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public void createInventory(UUID uuid){
            Vault v = new Vault(uuid);
            v.inv = Bukkit.createInventory(v, 54);
            vaults.put(uuid, v);
    }

    public Vault openVault(UUID uuid){
        if(!vaults.containsKey(uuid)){
            createInventory(uuid);
        }
        Vault v = vaults.get(uuid);
        return v;
    }
    public void saveVault(UUID uuid, Vault vault){
        vaults.put(uuid,vault);

    }
    public void saveVaults(){

            File folder = javaPlugin.getDataFolder();
            if(!javaPlugin.getDataFolder().exists()){
                javaPlugin.getDataFolder().mkdirs();
            }

            File file = new File(javaPlugin.getDataFolder(), "vaults.yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("vaults", null);
            for(Map.Entry<UUID, Vault> entry : vaults.entrySet()){
                UUID uuid = entry.getKey();
                Vault vault = entry.getValue();
                Inventory inv = vault.getInventory();
                for(int i =0; i<inv.getSize(); i++){
                    ItemStack item = inv.getItem(i);
                    config.set("vaults."+uuid.toString()+"."+i,item);
                }
            }
            try{
                config.save(file);
            }catch(Exception e){
                e.printStackTrace();
            }


    }

    }


