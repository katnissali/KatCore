package com.katnissali.katcore.Items.Guis;

import com.katnissali.katcore.Items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public abstract class ItemButton extends ItemBuilder {

    //  CONSTRUCTORS
    public ItemButton(ItemStack item){
        super(item);
    }
    public ItemButton(ItemBuilder item){
        super(item);
    }
    public ItemButton(Material material){
        super(material);
    }
    public ItemButton(Material material, int amount){
        super(material, amount);
    }
    public abstract void clickButton(Event event);
}
