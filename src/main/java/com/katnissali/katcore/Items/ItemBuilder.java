package com.katnissali.katcore.Items;

import com.katnissali.katcore.Core.Util;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder extends ItemStack {

    public ItemBuilder(Material type){
        super(type, 1);
    }
    public ItemBuilder(Material type, int amount){
        super(type, amount);
    }
    public ItemBuilder(ItemStack item){
        super(item);
    }

    //  GETTERS
    public String getDisplayName(){
        return getItemMeta().getDisplayName();
    }
    public List<String> getLore(){ return getItemMeta().getLore(); }

    //  SETTERS
    public ItemBuilder setName(String name) {
        getItemMeta().setDisplayName(name);
        return this;
    }
    public ItemBuilder setLore(String... str){
        getItemMeta().setLore(new ArrayList<>());
        for(String string : str){
            addLore(string);
        }
        return this;
    }
    public ItemBuilder setLore(List<String> lore){
        getItemMeta().setLore(lore);
        return this;
    }
    public ItemBuilder addLore(String str){
        List<String> lore = getItemMeta().getLore();
        lore.add(str);
        getItemMeta().setLore(lore);
        return this;
    }
    public ItemBuilder setSkull(OfflinePlayer player){
        setType(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) getItemMeta();
        meta.setOwningPlayer(player);
        return this;
    }
    public ItemBuilder replaceInLore(String target, String replacement){
        List<String> lore = getLore();
        if(lore == null) return this;
        for(String str : lore){
            Util.replace(str, target, replacement);
        }
        setLore(lore);
        return this;
    }
    public ItemBuilder setDisplayName(String name){
        getItemMeta().setDisplayName(name);
        return this;
    }

    //  MISC
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ItemStack)) return false;
        ItemStack item = (ItemStack) obj;
        return (item.getType() == getType()) && (item.getItemMeta().getLore().equals(getLore())) && (item.getItemMeta().getDisplayName().equals(getDisplayName()));
    }
    @Override
    public ItemBuilder clone(){
        return new ItemBuilder(super.clone());
    }

}
