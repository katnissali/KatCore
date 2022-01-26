package com.katnissali.katcore.Config;

import com.katnissali.katcore.Core.Util;
import com.katnissali.katcore.Items.ArmorSet;
import com.katnissali.katcore.Items.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class YamlConfig extends YamlConfiguration {

    private final File file;
    private final String name;

    protected YamlConfig(String name){
        String ymlAddition = (name.endsWith(".yml")?"":".yml");
        this.name = name + ymlAddition;
        this.file = new File(Util.getMain().getDataFolder(), this.name);
        saveDefault();
        reload();
    }

    public String getColoredString(String path){
        return ChatColor.translateAlternateColorCodes('&', getString(path));
    }
    public void reload(){
        try{
            super.load(file);
        } catch (Exception e){
            Util.printError("Unable to reload file: " + name);
            e.printStackTrace();
        }
    }
    public void save(){
        try{
            super.save(file);
        } catch (Exception e){
            Util.printError("Unable to save file: " + name);
            e.printStackTrace();
        }
    }
    public void saveDefault(){
        try{
            if(!file.exists()){
                if(Util.getMain().getResource(name) != null){
                    Util.getMain().saveResource(name, false);
                } else {
                    file.createNewFile();
                }
            }
        } catch (Exception e){
            Util.printError("Unable to save default file: " + name);
            e.printStackTrace();
        }
    }
    public String getFileName(){ return name; }

    public ArmorSet getArmorSet(String parentPath){
        ItemStack helmet = getItemStack(parentPath + ".helmet");
        ItemStack chestplate = getItemStack(parentPath + ".chestplate");
        ItemStack leggings = getItemStack(parentPath + ".leggings");
        ItemStack boots = getItemStack(parentPath + ".boots");
        return new ArmorSet(helmet, chestplate, leggings, boots);
    }

    @Override
    public void set(String path, Object value) {
        if(value instanceof ConfigObject) ((ConfigObject)value).saveToConfig(this, path);
        else super.set(path, value);
        save();
    }
}
