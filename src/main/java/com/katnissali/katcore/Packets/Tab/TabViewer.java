package com.katnissali.katcore.Packets.Tab;

import com.katnissali.katcore.Misc.CustomPlayer;
import org.bukkit.entity.Player;

public class TabViewer extends CustomPlayer {

    private TabList tabList = null;

    public TabViewer(Player player) {
        super(player);
    }

    public TabList getTabList(){ return tabList; }
    public void setTabList(TabList tabList) {
        this.tabList.removeViewer(this);
        tabList.addViewer(this);

        this.tabList = tabList;
    }
}
