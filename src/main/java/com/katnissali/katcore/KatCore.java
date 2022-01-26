package com.katnissali.katcore;

import com.katnissali.katcore.Bungee.BungeeUtil;
import com.katnissali.katcore.Core.Util;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class KatCore extends JavaPlugin {

    private boolean loadConfig = true;
    private boolean loadCore = true;
    private boolean loadBungee = false;

    public KatCore(boolean loadConfig, boolean loadCore, boolean loadBungee){
        this.loadCore = loadCore;
        this.loadConfig = loadConfig;
        this.loadBungee = loadBungee;
    }
    public KatCore(){}

    @Override
    public void onEnable() {
        Util.print(Util.format(getConfig().getString("messages.prefix") + "Enabling " + this.getName()));

        if(loadCore && !loadCore()){
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if(loadBungee){
            Util.log("Loading bungee.");
            new BungeeUtil();
            Util.log("Loaded bungee.");
        }

        if(loadConfig)
            loadConfig();

        Util.log("Loading commands and events.");
        registerCommands();
        registerEvents();

        Util.print(Util.getPrefix() + "Enabled " + this.getName());
    }

    @Override
    public void onDisable() {
        Util.print(Util.getPrefix() + "Disabling plugin.");
    }
    public boolean loadCore(){
        Util.log("Loading core.");
        if(getInstance() == null){
            Util.printError("getInstance() of main is null, disabling plugin.");
            return false;
        }
        new Util(getInstance());
        Util.log("Loaded core.");
        return true;
    }
    protected abstract KatCore getInstance();
    private void loadConfig(){
        Util.log("Loading config.");
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        reloadConfig();
        loadCustomConfigs();
        Util.log("Config loaded.");
    }
    public void reloadAllConfig() {
        this.reloadConfig();
        Util.getConfigManager().reloadAll();
    }
    protected void registerEvents(){}
    protected void registerCommands(){}
    protected void loadCustomConfigs(){}

}
