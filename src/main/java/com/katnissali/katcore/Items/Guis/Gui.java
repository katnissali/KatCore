package com.katnissali.katcore.Items.Guis;

import com.katnissali.katcore.Core.Util;
import com.katnissali.katcore.Items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.EventListener;
import java.util.HashMap;

public class Gui {

    private String title;
    private Inventory inventory;
    private HashMap<Integer, ItemButton> buttons = new HashMap<>();
    private Material backgroundMaterial = null;

    private EventListener clickListener = new EventListener() {
        @EventHandler
        public void onInventoryClick(InventoryClickEvent e){
            if(this.equals(e.getInventory()))
                onClick(e);
        }
    };

    public Gui(InventoryHolder holder, int size, String title){
        this.title = title;
        inventory = Bukkit.createInventory(holder, size, title);
    }

    public void setBackground(Material material){
        backgroundMaterial = material;
        ItemButton item = new ItemButton(material){
            @Override
            public void onClick(Gui gui, InventoryClickEvent e) {
                e.setCancelled(true);
            }
        };
        item.setDisplayName("");
        for(int i = 0; i < inventory.getSize(); i++){
            setButton(i, item);
        }
    }
    public void setButton(int slot, ItemButton button){
        if(getButton(slot) != null) removeButton(slot);
        buttons.put(slot, button);
        inventory.setItem(slot, button);
    }
    public void removeButton(int slot){
        buttons.remove(slot);
        inventory.setItem(slot, null);
        setBackground(backgroundMaterial);
    }
    public int addButton(ItemStack item){
        for(int i = 0; i < inventory.getSize(); i++){
            if(Util.isAir(inventory.getItem(i))){
                buttons.put(i, new ItemButton(item));
                inventory.setItem(i, getButton(i));
                return i;
            }
        }
        return -1;
    }
    public void openInv(HumanEntity entity){
        entity.openInventory(inventory);
    }
    public ItemButton getButton(int slot){
        return buttons.get(slot);
    }
    public String getTitle(){ return title; }
    public Inventory setTitle(String title){
        inventory = Bukkit.createInventory(this.inventory.getHolder(), this.inventory.getSize(), title);
        inventory.setContents(this.inventory.getContents());
        return inventory;
    }
    public void onClick(InventoryClickEvent e){
        getButton(e.getSlot()).onClick(this, e);
    }

    @Override
    public boolean equals(Object obj) {
        boolean sameTitle = false;
        if(obj instanceof Gui){
            sameTitle = ChatColor.stripColor(((Gui)obj).getTitle()).equals(ChatColor.stripColor(getTitle()));
        } else if(obj instanceof InventoryView){
            sameTitle = ChatColor.stripColor(((InventoryView)obj).getTitle()).equals(ChatColor.stripColor(getTitle()));
        }
        return super.equals(obj) || sameTitle;
    }
}
