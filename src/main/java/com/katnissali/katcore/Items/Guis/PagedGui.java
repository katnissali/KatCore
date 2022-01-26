package com.katnissali.katcore.Items.Guis;

import com.katnissali.katcore.Items.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PagedGui {

    private List<Gui> pages = new ArrayList<>();

    private ItemButton nextPageButton;
    private ItemButton previousPageButton;
    private int nextPageButtonIndex;
    private int previousPageButtonIndex;

    public PagedGui(Gui... pages){
        this.pages = Arrays.asList(pages);

        setNextPageButton(52, new ItemBuilder(Material.PAPER));
        setPreviousPageButton(46, new ItemBuilder(Material.PAPER));
    }
    public PagedGui(){
        addPage(new Gui(null, 27, "Default Page"));

        setNextPageButton(52, new ItemBuilder(Material.PAPER));
        setPreviousPageButton(46, new ItemBuilder(Material.PAPER));
    }

    //  SETTERS
    public void addPage(Gui gui){
        pages.add(gui);
        update();
    }
    public void removePage(int index){
        pages.remove(index-1);
        update();
    }
    private void update(){
        for(Gui gui : pages){
            if(!isLastPage(gui)){
                gui.setButton(nextPageButtonIndex, nextPageButton);
            }
            if(!isFirstPage(gui)){
                gui.setButton(previousPageButtonIndex, nextPageButton);
            }
        }
    }
    public void addButtonToAdd(int index, ItemButton button){
        for(Gui gui : pages){
            gui.setButton(index, button);
        }
    }
    public void setNextPageButton(int slot, ItemStack item) {
        this.nextPageButtonIndex = slot;

        nextPageButton = new ItemButton(item) {
            @Override
            public void onClick(Gui gui, InventoryClickEvent e) {
                getPage(getIndex(getPage(e.getView())) + 1).openInv(e.getWhoClicked());
            }
        };
        update();
    }
    public void setPreviousPageButton(int slot, ItemStack item) {
        this.previousPageButtonIndex = slot;

        previousPageButton = new ItemButton(item) {
            @Override
            public void onClick(Gui gui, InventoryClickEvent e) {
                getPage(getIndex(getPage(e.getView())) - 1).openInv(e.getWhoClicked());
            }
        };
        update();
    }

    //  GETTERS
    public Gui getPage(int index){ return pages.get(index-1); }
    public Gui getPage(InventoryView view){
        for(Gui gui : pages){
            if(gui.equals(view)){
                return gui;
            }
        }
        return null;
    }
    public int getIndex(Gui gui){
        for(int i = 0; i < pages.size(); i++){
            if(getPage(i).equals(gui)) return i;
        }
        return -1;
    }
    public Gui getFirstPage(){ return getPage(0); }
    public Gui getLastPage(){ return getPage(pages.size() - 1); }
    public boolean isFirstPage(Gui gui){
        return getFirstPage().equals(gui);
    }
    public boolean isLastPage(Gui gui){
        return getLastPage().equals(gui);
    }
}
