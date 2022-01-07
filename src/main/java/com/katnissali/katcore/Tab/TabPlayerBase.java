package com.katnissali.katcore.Tab;

import com.katnissali.katcore.Misc.CustomPlayer;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class TabPlayerBase {

    public EntityPlayer getEntityPlayer() {
        return new EntityPlayer(getMinecraftServer(), getWorldServer(), getGameProflie(), getPlayerInteractManager());
    }

    public abstract MinecraftServer getMinecraftServer();
    public abstract WorldServer getWorldServer();
    public abstract GameProfile getGameProflie();
    public abstract PlayerInteractManager getPlayerInteractManager();

}
