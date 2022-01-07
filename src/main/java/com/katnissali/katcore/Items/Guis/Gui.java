package com.katnissali.katcore.Items.Guis;
//
//import org.bukkit.event.inventory.InventoryInteractEvent;
//import org.bukkit.inventory.Inventory;
//import org.bukkit.inventory.ItemStack;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.function.Function;
//
//public class Gui extends CustomInventory {
//
//    private HashMap<Integer, ItemButton> buttons = new HashMap<>();
//    private boolean closeOnButtonClick = false;
//
//    public Gui(int size, String title, boolean closeOnButtonClick){
//        super(size, title);
//        this.closeOnButtonClick = closeOnButtonClick;
//    }
//    public Gui(Inventory inventory, boolean closeOnButtonClick){
//        super(inventory);
//        this.closeOnButtonClick = closeOnButtonClick;
//    }
//
//    //  SETTERS
//    public void setCloseOnButtonClick(boolean closeOnButtonClick){ this.closeOnButtonClick = closeOnButtonClick; }
//    public void addButton(ItemButton button){
//        buttons.put(buttons.size(), button);
//    }
//    public void clickButton(int slot, InventoryInteractEvent e){
//        clickButton(getButton(slot), e);
//    }
//    public void clickButton(ItemButton button, InventoryInteractEvent e){
//        button.clickButton();
//        e.setCancelled(button.getCancelClickEvent());
//        if(closeOnButtonClick) e.getWhoClicked().closeInventory();
//    }
//    public void addButton(ItemButton button, int slot){
//        buttons.replace(slot, button);
//    }
//    public void addButton(ItemStack item, int slot, boolean cancelClickEvent, Method method){
//        ItemButton button = new ItemButton(item, cancelClickEvent) {
//            @Override
//            public void clickButtonAbstract(Object... input) {}
//        };
//        button.setCustomClickMethod(method);
//        addButton(button, slot);
//    }
//
//    //  GETTERS
//    public boolean getCloseOnButtonClick(){ return closeOnButtonClick; }
//    public ItemButton getButton(int slot){
//        return buttons.get(slot);
//    }
//    public Collection<ItemButton> getButtons(){ return buttons.values(); }
//    public HashMap<Integer, ItemButton> getButtonHash(){ return buttons; }
//
//}

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.*;

public class Gui extends CustomInventory {

    public Gui(Inventory inventory) {
        super(inventory);
    }
    public Gui(InventoryHolder owner, int size, String title) {
        super(owner, size, title);
    }

    public void addButton(GuiButton button){
        addButton(getFirstOpenSlot(), button);
    }
    public void addButton(int slot, GuiButton button){
        while(getButton(slot) != null) getButtons().remove(button);
    }
    public GuiButton getButton(int slot){ return getButtons().get(slot); }

    public HashMap<Integer, GuiButton> getButtons(){
        HashMap<Integer, GuiButton> buttons = new HashMap<>();
        for(int i = 0; i <= getSize(); i++){
            if(getItem(i) instanceof GuiButton) buttons.put(i, (GuiButton) getItem(i));
        }
        return buttons;
    }

}