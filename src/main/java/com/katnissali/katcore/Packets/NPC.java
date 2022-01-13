package com.katnissali.katcore.Packets;

import com.katnissali.katcore.Core.Util;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class NPC extends EntityPlayer {

    public NPC(String playerName, Location location){
        super(PacketUtil.getServer(),
                PacketUtil.getWorld(location.getWorld()),
                new GameProfile(UUID.randomUUID(), playerName),
                new PlayerInteractManager(PacketUtil.getWorld(location.getWorld())));

        setLocation(location);
    }

    public void show(Player... players){
        Arrays.stream(players).forEach(player -> {
            PlayerConnection connection = PacketUtil.getPlayerConnection(player);
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, this));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(this));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(this, getAppliedYaw(yaw))); //  TODO what?
        });
    }
    public void remove(Player... players){
        PacketUtil.sendPacketToPlayers(new PacketPlayOutEntityDestroy(getId()), players);
    }

    public void setLocation(Location location){
        super.setLocation(location.getX(), location.getY(), location.getZ(), yaw, pitch);
    }
    public void rotate(float yaw, float pitch, Player... players){
        Arrays.stream(players).forEach(player -> {
            PacketUtil.getPlayerConnection(player).sendPacket(new PacketPlayOutEntityHeadRotation(this, getAppliedYaw(yaw)));
            PacketUtil.getPlayerConnection(player).sendPacket(new PacketPlayOutEntity.PacketPlayOutEntityLook(getId(), getAppliedPitch(pitch), getAppliedYaw(yaw), true));  //  TODO why true
        });
    }
    public void move(Location newLoc, Player... players) {
        Arrays.stream(players).forEach(player -> {
            PacketUtil.sendPacketsToPlayer(player, new PacketPlayOutEntity.PacketPlayOutRelEntityMove(getId(), (short)(newLoc.getX()*4096), (short)(newLoc.getY()*4096), (short)(newLoc.getZ()*4096), true));
            //  TODO WHY TRUE?
        });
    }

    public void setSkin(String username, Player... players) {
        remove(players);

        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URL(String.format("https://api.ascon.app/mojang/v2/user/%s", username)).openConnection();
            if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                ArrayList<String> lines = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                reader.lines().forEach(lines::add);

                String reply = String.join(" ", lines);
                int indexOfValue = reply.indexOf("\"value\": \"");
                int indexOfSignature = reply.indexOf("\"signature\": \"");

                String skin = reply.substring(indexOfValue + 10, reply.indexOf("\"", indexOfValue + 10));
                String signature = reply.substring(indexOfSignature + 14, reply.indexOf("\"", indexOfSignature + 14));
                getProfile().getProperties().put("textures", new Property("textures", skin, signature));
            } else {
                Util.printError("Connection could not be opened when fetching player skin. (Response code " + connection.getResponseCode() + ", " + connection.getResponseMessage() + ")");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        //  CLIENT SETTINGS
        getDataWatcher().set(new DataWatcherObject<>(15, DataWatcherRegistry.a), (byte)127);
        PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(getId(), getDataWatcher(), true);
        PacketUtil.sendPacketToPlayers(packet, players);

    }

    public byte getAppliedYaw(float yaw){
        return (byte)(yaw * 256/360);
    }
    public byte getAppliedPitch(float pitch){
        return (byte)(pitch * 256/360);
    }

}
