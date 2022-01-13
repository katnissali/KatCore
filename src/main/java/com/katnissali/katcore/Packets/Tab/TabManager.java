package com.katnissali.katcore.Packets.Tab;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class TabManager {

    private HashMap<String, TabViewer> viewers = new HashMap<>();

    public TabViewer getViewer(Player player){ return viewers.get(player.getName()); }
    public TabViewer registerViewer(Player player){
        if(getViewer(player) != null) viewers.remove(getViewer(player).getName());
        viewers.put(player.getName(), new TabViewer(player));
        return getViewer(player);
    }
    
}