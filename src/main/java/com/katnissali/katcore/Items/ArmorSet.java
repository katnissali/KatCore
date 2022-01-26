package com.katnissali.katcore.Items;

import com.katnissali.katcore.Config.ConfigObject;
import com.katnissali.katcore.Config.YamlConfig;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmorSet implements ConfigObject {

    private ItemBuilder helmet = null;
    private ItemBuilder chestplate = null;
    private ItemBuilder leggings = null;
    private ItemBuilder boots = null;

    public ArmorSet(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots){
        this.helmet = new ItemBuilder(helmet);
        this.chestplate = new ItemBuilder(chestplate);
        this.leggings = new ItemBuilder(leggings);
        this.boots = new ItemBuilder(boots);
    }
    public ArmorSet(){}

    //  GETTERS
    public ItemBuilder getHelmet(){ return helmet; }
    public ItemBuilder getChestplate(){ return chestplate; }
    public ItemBuilder getLeggings(){ return leggings; }
    public ItemBuilder getBoots(){ return boots; }

    //  SETTERS
    public void setHelmet(ItemBuilder helmet){ this.helmet = helmet; }
    public void setChestplate(ItemBuilder chestplate){ this.chestplate = chestplate; }
    public void setLeggings(ItemBuilder leggings){ this.leggings = leggings; }
    public void setBoots(ItemBuilder boots){ this.boots = boots; }
    public void applyArmor(Player player){
        if(helmet != null)  player.getInventory().setHelmet(helmet);
        if(chestplate != null)  player.getInventory().setHelmet(chestplate);
        if(leggings != null)  player.getInventory().setHelmet(leggings);
        if(boots != null)  player.getInventory().setHelmet(boots);

        player.updateInventory();
    }

    @Override
    public void saveToConfig(YamlConfig config, String path) {
        config.set(path + ".helmet", getHelmet());
        config.set(path + ".chestplate", getChestplate());
        config.set(path + ".leggings", getLeggings());
        config.set(path + ".boots", getBoots());
    }
}
