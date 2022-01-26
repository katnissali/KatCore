package com.katnissali.katcore.Config;

import com.katnissali.katcore.Config.YamlConfig;
import com.katnissali.katcore.Core.Util;

import java.util.HashMap;

public class ConfigManager {

    private HashMap<String, YamlConfig> configs = new HashMap<>();

    public ConfigManager(String... configs){
        for(String configName : configs){
            loadConfig(configName);
        }
    }

    public YamlConfig loadConfig(String name){
        Util.log("Loading config " + name + " to config manager.");
        YamlConfig config = new YamlConfig(name);
        loadConfig(config);
        Util.log("Loaded config " + name + ".");
        return config;
    }
    public YamlConfig loadConfig(YamlConfig config){
        configs.put(config.getFileName(), config);
        return config;
    }

    public void reloadAll(){
        Util.log("Reloading configs.");
        for(YamlConfig config : configs.values()){
            config.reload();
        }
        Util.log("Configs reloaded.");
    }
    public void saveConfigs(){
        Util.log("Saving configs...");
        for(YamlConfig config : configs.values()){
            config.save();
        }
        Util.getMain().saveConfig();
        Util.log("Configs saved.");
    }
    public YamlConfig getConfig(String name){
        return configs.get(name + (name.endsWith(".yml")?"":".yml"));
    }
    public HashMap<String, YamlConfig> getConfigs(){ return (HashMap<String, YamlConfig>) configs.clone(); }

}
