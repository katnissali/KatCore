package com.katnissali.katcore.Items;

import com.katnissali.katcore.Core.Util;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
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
    public ItemBuilder setLore(String... str){
        setLore(format(Arrays.asList(str)));
        return this;
    }
    public ItemBuilder setLore(List<String> lore){
        ItemMeta meta = getItemMeta();
        meta.setLore(format(lore));
        setItemMeta(meta);
        return this;
    }
    public ItemBuilder addLore(String str){
        ItemMeta meta = getItemMeta();
        List<String> lore = getItemMeta().getLore();
        if(lore == null) lore = new ArrayList<>();
        lore.add(Util.format(str));
        meta.setLore(lore);
        setItemMeta(meta);
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
        for(int i = 0; i < lore.size(); i++){
            lore.set(i, Util.replace(lore.get(i), target, Util.format(replacement)));
        }

        setLore(lore);
        String displayName = Util.replace(getDisplayName(), target, replacement);
        setDisplayName(Util.format(displayName));

        return this;
    }
    public ItemBuilder setDisplayName(String name){
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(Util.format(name));
        setItemMeta(meta);
        return this;
    }
    public ItemBuilder addAttributeModifier(Attribute attribute, AttributeModifier modifier){
        ItemMeta meta = getItemMeta();
        meta.addAttributeModifier(attribute, modifier);
        setItemMeta(meta);
        return this;
    }
    public ItemBuilder addItemFlags(ItemFlag... flags){
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(flags);
        setItemMeta(meta);
        return this;
    }

    //  MISC
    public ItemStack getItem(){ return super.clone(); }
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

    private List<String> format(List<String> list){
        for(int i = 0; i < list.size(); i++){
            list.set(i, Util.format(list.get(i)));
        }
        return list;
    }
}
