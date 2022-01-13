package com.katnissali.katcore.Packets.Tab;

import com.katnissali.katcore.Packets.PacketUtil;
import net.minecraft.server.v1_16_R3.PacketPlayOutPlayerInfo;
import org.bukkit.Bukkit;

import java.util.Arrays;

public class TabUtil {

    private static TabManager tabManager;

    public static final PacketPlayOutPlayerInfo.EnumPlayerInfoAction ADD = PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER;
    public static final PacketPlayOutPlayerInfo.EnumPlayerInfoAction REMOVE = PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER;

    //  MODIFIERS
    public static void addPlayerToAll(TabPlayerBase... players){
        Bukkit.getOnlinePlayers().forEach(receiver -> addTabPlayer(getTabManager().getViewer(receiver), players));
    }
    public static void removePlayerFromAll(TabPlayerBase... players){
        Bukkit.getOnlinePlayers().forEach(receiver -> removeTabPlayer(getTabManager().getViewer(receiver), players));
    }

    public static void addTabPlayer(TabViewer receiver, TabPlayerBase... players){
        Arrays.stream(players).forEach(player -> addTabPlayer(player, receiver));
    }
    public static void removeTabPlayer(TabViewer receiver, TabPlayerBase... players){
        Arrays.stream(players).forEach(player -> removeTabPlayer(player, receiver));
    }

    public static void addTabPlayer(TabPlayerBase player, TabViewer receiver){
        PacketUtil.sendPacketsToPlayer(receiver, getTabPacket(ADD, player));
    }
    public static void removeTabPlayer(TabPlayerBase player, TabViewer receiver){
        PacketUtil.sendPacketsToPlayer(receiver, getTabPacket(REMOVE, player));
    }

    public static void addTabPlayer(TabPlayerBase player, TabViewer... receivers){
        Arrays.stream(receivers).forEach(receiver -> addTabPlayer(player, receiver));
    }
    public static void removeTabPlayer(TabPlayerBase player, TabViewer... receivers){
        Arrays.stream(receivers).forEach(receiver -> removeTabPlayer(player, receiver));
    }

    //  UTIL
    public static PacketPlayOutPlayerInfo getTabPacket(PacketPlayOutPlayerInfo.EnumPlayerInfoAction action, TabPlayerBase player){
        return new PacketPlayOutPlayerInfo(action, player.getEntityPlayer());
    }
    public static void clearTab(TabViewer viewer){
        viewer.getTabList().removeViewer(viewer);
    }

    public static TabManager getTabManager(){
        if(tabManager == null) tabManager = new TabManager();
        return tabManager;
    }

}
