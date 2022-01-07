package com.katnissali.katcore.Registerables;

import com.katnissali.katcore.Core.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class EventListener implements Listener, Registerable{

    public EventListener(boolean register){
        if(register) register();
    }
    public EventListener(){ register(); }
    public void register() {
        Bukkit.getServer().getPluginManager().registerEvents(this, Util.getMain());
    }


}
