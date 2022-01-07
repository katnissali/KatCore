package com.katnissali.katcore.Tab;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import java.util.UUID;

public class TabPlayer extends TabPlayerBase {

    private String name;
    private String listName;
    private String texture;
    private String signature;

    public TabPlayer(String name, String listName, String texture, String signature){
        this.name = name;
        this.listName = listName;
        this.texture = texture;
        this.signature = signature;
    }


    //  MISC GETTERS AND SETTERS
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getListName() { return listName; }
    public void setListName(String listName) { this.listName = listName; }
    public String getTexture() { return texture; }
    public void setTexture(String texture) { this.texture = texture; }
    public String getSignature() { return signature; }
    public void setSignature(String signature) { this.signature = signature; }

    public EntityPlayer loadEntityPlayer(){
        EntityPlayer player = new EntityPlayer(getMinecraftServer(), getWorldServer(), getGameProflie(), getPlayerInteractManager());
        player.listName = new ChatComponentText(listName);
        return player;
    }
    public void updateInfo(){}

    @Override
    public MinecraftServer getMinecraftServer() {
        return ((CraftServer) Bukkit.getServer()).getServer();
    }
    @Override
    public WorldServer getWorldServer() {
        return ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle(); //getMinecraftServer().getWorlds().get(0);
    }
    @Override
    public GameProfile getGameProflie() {
        GameProfile profile = new GameProfile(UUID.randomUUID(), getName());
        profile.getProperties().put("textures", new Property(getTexture(), getSignature()));
        return profile;
    }
    @Override
    public PlayerInteractManager getPlayerInteractManager() {
        return new PlayerInteractManager(getWorldServer());
    }
}