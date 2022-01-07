package com.katnissali.katcore;

import com.katnissali.katcore.Core.Util;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class KatCore extends JavaPlugin {

    @Override
    public void onEnable() {
        Util.print(Util.format(getConfig().getString("messages.prefix") + "Enabling " + this.getName()));
        if(!loadCore()){
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        loadConfig();

        Util.log("Loading commands and events.");
        registerCommands();
        registerEvents();
        Util.log("Loaded commands and events.");

        Util.print(Util.getPrefix() + "Enabled " + this.getName());
    }

    @Override
    public void onDisable() {
        Util.print(Util.getPrefix() + "Disabling plugin.");
        Util.getConfigManager().saveConfigs();
    }
    public boolean loadCore(){
        Util.log("Loading core.");
        if(getInstance() == null){
            Util.printError("getInstance() of main is null, disabling plugin.");
            return false;
        }
        Util.setup(getInstance());
        Util.log("Loaded core.");
        return true;
    }
    protected abstract KatCore getInstance();
    private void loadConfig(){
        Util.log("Loading config.");
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        reloadConfig();
        Util.log("Config loaded.");
    }
    protected void registerEvents(){}
    protected void registerCommands(){}

}
