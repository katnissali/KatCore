package com.katnissali.katcore.Items.Guis;

import com.katnissali.katcore.Items.ItemBuilder;
import com.katnissali.katcore.Registerables.EventListener;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;

public class GuiButton extends ItemButton {

    private EventListener clickListener;
    private boolean closeInventoryOnClick;

    public GuiButton(ItemStack item, boolean closeInventory) {
        super(item);
        this.closeInventoryOnClick = closeInventory;
    }
    public GuiButton(ItemBuilder item, boolean closeInventory) {
        super(item);
        this.closeInventoryOnClick = closeInventory;
    }
    public GuiButton(Material material, boolean closeInventory) {
        super(material);
        this.closeInventoryOnClick = closeInventory;
    }
    public GuiButton(Material material, int amount, boolean closeInventory) {
        super(material, amount);
        this.closeInventoryOnClick = closeInventory;
    }

    @Override
    public final void clickButton(Event event) {
        if(!(event instanceof InventoryInteractEvent)) return;

        InventoryInteractEvent e = (InventoryInteractEvent) event;
        if(closeInventoryOnClick) e.getWhoClicked().closeInventory();
        clickButton(e);
    }
    public void clickButton(InventoryInteractEvent event){}

    public void setClickListener(EventListener clickListener){ this.clickListener = clickListener; }
    public EventListener getClickListener(){ return clickListener; }
    public boolean closeInventoryOnClick(){ return closeInventoryOnClick; }
    public void setCloseInventoryOnClick(boolean closeInventoryOnClick){ this.closeInventoryOnClick = closeInventoryOnClick; }
}
