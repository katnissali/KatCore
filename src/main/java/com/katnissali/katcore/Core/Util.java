package com.katnissali.katcore.Core;

import com.katnissali.katcore.Bungee.BungeeUtil;
import com.katnissali.katcore.Config.ConfigManager;
import com.katnissali.katcore.KatCore;
import net.minecraft.server.v1_16_R3.Packet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Util {

    private static KatCore main;
    protected static ConfigManager configManager;
    private static BungeeUtil bungeeUtil;

    public static void setup(KatCore m){
        main = m;
        configManager = new ConfigManager();
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
    public static String getPrefix(){ return getColoredConfigString("messages.prefix"); }
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

    //  SETTERS
    public static void setBungeeUtil(BungeeUtil bUtil){ bungeeUtil = bUtil;}
    public static BungeeUtil addBungee(){
        if(bungeeUtil == null) return bungeeUtil = new BungeeUtil();
        else return bungeeUtil;
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
