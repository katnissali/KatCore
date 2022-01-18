package com.katnissali.katcore.Config;

import java.util.HashMap;

public class ConfigObject {

    private HashMap<String, Object> children = new HashMap<String, Object>();
    private final String parentPath;

    public ConfigObject(String parentPath, HashMap<String, Object> children){
        this.parentPath = parentPath;
        this.children = children;
    }
    public ConfigObject(String parentPath){
        this.parentPath = parentPath;
    }

    public void saveToConfig(YamlConfig config){
        for(String path : children.keySet()){
            config.set(path, getObject(path));
        }
        config.save();
    }
    public void loadFromConfig(YamlConfig config){
        for(String path : config.getConfigurationSection(parentPath).getKeys(false)){
            add(parentPath + "." + path, config.get(parentPath + "." + path));
        }
    }

    public Object getObject(String path){ return children.get(path); }
    public ConfigObject add(String path, Object object){
        children.put(path, object);
        return this;
    }
}
