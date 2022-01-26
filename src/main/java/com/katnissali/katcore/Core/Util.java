package com.katnissali.katcore.Core;

import com.katnissali.katcore.Bungee.BungeeUtil;
import com.katnissali.katcore.Config.ConfigManager;
import com.katnissali.katcore.KatCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    private static KatCore main;
    protected static ConfigManager configManager;
    private static BungeeUtil bungeeUtil;

    public Util(KatCore m){
        if(main == null) main = m;
        if(configManager == null) configManager = new ConfigManager();
    }

    //  CLASS GETTERS
    public static BungeeUtil getBungeeUtil(){ return bungeeUtil; }
    public static KatCore getMain(){ return main; }
    public static ConfigManager getConfigManager(){ return configManager; }

    //  GETTERS
    public static String format(String str){
        return ChatColor.translateAlternateColorCodes('&', str);
    }
    public static String getColoredConfigString(String path){
        return format(main.getConfig().getString(path));
    }
    public static Player getRandomPlayer(){
        for(Player player : Bukkit.getOnlinePlayers()){ return player; }
        return null;
    }
    public static String getPrefix(){
        return Util.format(main.getConfig().getString("messages.prefix"));
    }
    public static Object[] listToArray(List<Object> items){
        Object[] obj = new Object[items.size()];
        for(int i = 0; i < items.size(); i++){ obj[i] = items.get(i); }
        return obj;
    }
    public static boolean isValidNumber(String str) {
        try{
            Integer.valueOf(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static String replace(String str, String target, String replacement){
        while(str.contains(target)){
            str = str.replace(target, replacement);
        }
        return str;
    }
    public static boolean isInteger(String str){
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    public static Object randomFromList(ArrayList<Object> list){
        return list.get(new Random().nextInt(list.size()-1));
    }
    public static boolean hasBungee(){ return bungeeUtil != null; }
    public static List<String> format(List<String> list){
        if(list == null) return null;
        for(int i = 0; i < list.size(); i++){
            list.set(i, Util.format(list.get(i)));
        }
        return list;
    }

    //  SETTERS
    public static void setBungeeUtil(BungeeUtil bUtil){ bungeeUtil = bUtil;}
    public static BungeeUtil addBungee(){
        if(bungeeUtil == null) return bungeeUtil = new BungeeUtil();
        else return bungeeUtil;
    }
    @Nullable
    public static File saveResourceToDataFolder(String name){
        log("Saving resource " + name + " to data folder!");
        log("test2");
        File file = new File(main.getDataFolder(), name);
        log("file: " + file);
        try {
            if (!file.exists()) {
                log(name + " does not exist, attempting to load a new file.");
                if (main.getResource(name) != null) {
                    log("Found " + name + " resource file");
                    main.saveResource(name, false);
                    log("Saved " + name + " resource file.");
                    return file;
                } else {
                    printError(name + " file not found in plugin resource folder, please add the file manually.");
                    return null;
                }
            } else {
                log("File already exists!");
                return file;
            }
        } catch (Exception e) {
            printError("Unable to save default file: " + name);
            e.printStackTrace();
        }
        Util.debug("finished");
        return null;
    }
    public static void sendCommand(String str){ Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), str); }
    public static void noPermission(Player player){ player.sendMessage(ChatColor.RED + "You do not have permission to do this."); }
    public static void onlyPlayers(){ print(ChatColor.RED + "Only players can do this."); }
    public static void print(String str){ Bukkit.getServer().getConsoleSender().sendMessage(str); }
    public static void debug(String str){
        print(ChatColor.DARK_RED + "DEBUG" + ChatColor.DARK_RED + " >> " + ChatColor.RED + str);
    }
    public static void clearInventory(Player player){
        PlayerInventory inv = player.getInventory();
        inv.clear();
        if(isAir(inv.getHelmet())){ inv.getHelmet().setType(Material.AIR); }
        if(isAir(inv.getChestplate())){ inv.getChestplate().setType(Material.AIR); }
        if(isAir(inv.getLeggings())){ inv.getLeggings().setType(Material.AIR); }
        if(isAir(inv.getBoots())){ inv.getBoots().setType(Material.AIR); }
        player.updateInventory();
    }
    public static boolean isAir(ItemStack item){
        return item == null || item.getType().equals(Material.AIR);
    }
    public static void setAir(Inventory inv, int slot){ inv.setItem(slot, new ItemStack(Material.AIR)); }
    public static void triggerEvent(Event e){ Bukkit.getPluginManager().callEvent(e); }
    public static void printError(String error){
        print("" + ChatColor.DARK_RED + "ERROR" + ChatColor.DARK_RED + " >> " + ChatColor.RED + error);
    }
    public static void log(String msg){
        print(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "LOG >> " + ChatColor.BLUE + msg);
    }
}
