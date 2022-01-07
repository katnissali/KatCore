package com.katnissali.katcore.Items.Guis;

import com.katnissali.katcore.Core.Util;
import com.katnissali.katcore.Items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class CustomInventory implements Inventory, HasSuper {

    private ItemBuilder background;
    private String title;
    private final Inventory s;


    public CustomInventory(Inventory inventory){
        s = inventory;
    }
    public CustomInventory(InventoryHolder owner, int size, String title){
        s = Bukkit.createInventory(owner, size, title);
        this.title = title;
    }

    //  GETTERS
    public String getTitle(){ return title; }
    public ItemBuilder getBackground(){ return background; }

    //  SETTERS
    public void setBackground(ItemBuilder item){
        background = item;
        for(int i = 0; i < getSize(); i++){
            setItem(i, item);
        }
    }
    public void setBackGround(Material material){
        ItemBuilder item = new ItemBuilder(material).setDisplayName("").setLore("");
        setBackground(item);
    }


    @Override
    public Inventory getSuper() {
        return s;
    }


    @Override
    public int getSize() {
        return getSuper().getSize();
    }

    @Override
    public int getMaxStackSize() {
        return getSuper().getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        getSuper().setMaxStackSize(i);
    }

    @Override
    public ItemStack getItem(int i) {
        return getSuper().getItem(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        getSuper().setItem(i, itemStack);
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return getSuper().addItem(itemStacks);
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return getSuper().removeItem(itemStacks);
    }

    @Override
    public ItemStack[] getContents() {
        return getSuper().getContents();
    }

    @Override
    public void setContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        getSuper().setContents(itemStacks);
    }

    @Override
    public ItemStack[] getStorageContents() {
        return getSuper().getStorageContents();
    }

    @Override
    public void setStorageContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        getSuper().setStorageContents(itemStacks);
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return getSuper().contains(material);
    }

    @Override
    public boolean contains(ItemStack itemStack) {
        return getSuper().contains(itemStack);
    }

    @Override
    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return getSuper().contains(material, i);
    }

    @Override
    public boolean contains(ItemStack itemStack, int i) {
        return getSuper().contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return getSuper().containsAtLeast(itemStack, i);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return getSuper().all(material);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return getSuper().all(itemStack);
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        return getSuper().first(material);
    }
    public int getFirstOpenSlot(){
        for(int i = 0; i <= getSize(); i++){
            if(Util.isAir(getItem(i))) return i;
        }
        return -1;
    }

    @Override
    public int first(ItemStack itemStack) {
        return getSuper().first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return getSuper().firstEmpty();
    }

    @Override
    public boolean isEmpty() {
        return getSuper().isEmpty();
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        getSuper().remove(material);
    }

    @Override
    public void remove(ItemStack itemStack) {
        getSuper().removeItem(itemStack);
    }

    @Override
    public void clear(int i) {
        getSuper().clear(i);
    }

    @Override
    public void clear() {
        getSuper().clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        return getSuper().getViewers();
    }

    @Override
    public InventoryType getType() {
        return getSuper().getType();
    }

    @Override
    public InventoryHolder getHolder() {
        return getSuper().getHolder();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return getSuper().iterator();
    }

    @Override
    public ListIterator<ItemStack> iterator(int i) {
        return getSuper().iterator(i);
    }

    @Override
    public Location getLocation() {
        return getSuper().getLocation();
    }

    @Override
    protected CustomInventory clone() {
        Inventory inventory = Bukkit.createInventory(null, getSize(), getTitle());
        inventory.setContents(getContents());
        return new CustomInventory(inventory);
    }

}
