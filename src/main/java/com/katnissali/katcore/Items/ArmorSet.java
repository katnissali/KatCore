package com.katnissali.katcore.Items;

import com.katnissali.katcore.Items.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmorSet {

    private ItemBuilder helmet;
    private ItemBuilder chestplate;
    private ItemBuilder leggings;
    private ItemBuilder boots;

    public ArmorSet(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots){
        this.helmet = new ItemBuilder(helmet);
        this.chestplate = new ItemBuilder(chestplate);
        this.leggings = new ItemBuilder(leggings);
        this.boots = new ItemBuilder(boots);
    }
    public ArmorSet(ItemBuilder helmet, ItemBuilder chesplate, ItemBuilder leggings, ItemBuilder boots){
        this.helmet = helmet;
        this.chestplate = chesplate;
        this.leggings = leggings;
        this.boots = boots;
    }

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
        player.getInventory().setHelmet(helmet);
        player.getInventory().setChestplate(chestplate);
        player.getInventory().setHelmet(leggings);
        player.getInventory().setBoots(boots);
        player.updateInventory();
    }



}
