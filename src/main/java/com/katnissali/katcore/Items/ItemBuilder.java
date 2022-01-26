package com.katnissali.katcore.Items;

import com.katnissali.katcore.Config.ConfigObject;
import com.katnissali.katcore.Config.YamlConfig;
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

public class ItemBuilder extends ItemStack implements ConfigObject {

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
        setLore(Util.format(Arrays.asList(str)));
        return this;
    }
    public ItemBuilder setLore(List<String> lore){
        ItemMeta meta = getItemMeta();
        meta.setLore(Util.format(lore));
        setItemMeta(meta);
        return this;
    }
    public ItemBuilder addLore(String... strs){
        ItemMeta meta = getItemMeta();
        List<String> lore;

        if(getLore() == null){
            lore = new ArrayList<>();
        } else {
            lore = getLore();
        }

        Arrays.stream(strs).forEach(str -> lore.add(Util.format(str)));

        assert meta != null;
        meta.setLore(lore);
        setItemMeta(meta);
        return this;
    }
    public ItemBuilder setSkull(OfflinePlayer player){
        setType(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) getItemMeta();
        assert meta != null;
        meta.setOwningPlayer(player);
        setItemMeta(meta);
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
    public ItemBuilder addItemFlag(ItemFlag... flags){
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(flags);
        setItemMeta(meta);
        return this;
    }

    //  MISC
    public ItemStack getItem(){ return new ItemStack(super.clone()); }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ItemStack)) return super.equals(obj);
        ItemStack item = (ItemStack) obj;
        return super.equals(obj) || ((item.getType() == getType()) && (item.getItemMeta().getLore().equals(getLore())) && (item.getItemMeta().getDisplayName().equals(getDisplayName())));
    }
    @Override
    public ItemBuilder clone(){
        return new ItemBuilder(super.clone());
    }

    @Override
    public void saveToConfig(YamlConfig config, String path) {
        config.set(path, new ItemStack(this));
    }
}
