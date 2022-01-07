package com.katnissali.katcore.Tab;

import org.bukkit.entity.Player;

import java.util.*;

public class TabList {

    private String name;
    private HashMap<String, TabPlayerBase> players = new HashMap<>();
    public ArrayList<Player> vieweres = new ArrayList<Player>();

    public TabList(String name, HashMap<String, TabPlayerBase> players){
        this.players = players;
        this.name = name;
    }
    public TabList(String name){
        this.name = name;
    }

    public void update(){
        players.forEach((name, player) -> TabUtil.addTabPlayer(player, (TabViewer[]) vieweres.toArray()));
    }

    public Collection<TabPlayerBase> getPlayers(){ return players.values(); }
    public ArrayList<Player> getVieweres(){ return vieweres; }
    public void addViewer(TabViewer viewer){
        TabUtil.clearTab(viewer);
        TabUtil.addTabPlayer(viewer, (TabPlayerBase[])players.values().toArray());
        addViewer(viewer);
    }
    public void removeViewer(TabViewer viewer){
        TabUtil.removeTabPlayer(viewer, (TabPlayerBase[])players.values().toArray());
        viewer.setTabList(null);
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof TabList)) return false;
        return this.vieweres.equals(((TabList) o).vieweres) && this.getPlayers().equals(((TabList) o).getPlayers());
    }
}
