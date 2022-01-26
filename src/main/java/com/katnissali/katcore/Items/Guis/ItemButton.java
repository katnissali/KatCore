package com.katnissali.katcore.Items.Guis;

import com.katnissali.katcore.Items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ItemButton extends ItemBuilder {

    public ItemButton(Material type) {
        super(type);
    }
    public ItemButton(){
        super(Material.AIR);
    }

    public ItemButton(Material type, int amount) {
        super(type, amount);
    }

    public ItemButton(ItemStack item) {
        super(item);
    }

    public void onClick(Gui gui, InventoryClickEvent e){}

}
