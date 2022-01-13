package com.katnissali.katcore.Packets;

import net.minecraft.server.v1_16_R3.MinecraftServer;
import net.minecraft.server.v1_16_R3.Packet;
import net.minecraft.server.v1_16_R3.PlayerConnection;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class PacketUtil {

    public static void sendPacketsToAllPlayers(Packet<?>... packets){
        Bukkit.getOnlinePlayers().forEach(player -> sendPacketsToPlayer(player, packets));
    }
    public static void sendPacketsToPlayer(Player player, Packet<?>... packets){
        Arrays.stream(packets).forEach(packet -> ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet));
    }
    public static void sendPacketToPlayers(Packet<?> packet, Player... players){
        Arrays.stream(players).forEach(player -> sendPacketsToPlayer(player, packet));
    }
    public static MinecraftServer getServer(){ return ((CraftServer)Bukkit.getServer()).getServer(); }
    public static WorldServer getWorld(World world){ return ((CraftWorld)world).getHandle(); }
    public static WorldServer getWorld(){ return ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle(); }
    public static PlayerConnection getPlayerConnection(Player player){ return ((CraftPlayer)player).getHandle().playerConnection; }

}
