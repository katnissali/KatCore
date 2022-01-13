package com.katnissali.katcore.Packets.Tab;

import com.katnissali.katcore.Packets.PacketUtil;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.*;

public abstract class TabPlayerBase {

    public EntityPlayer getEntityPlayer() {
        return new EntityPlayer(PacketUtil.getServer(), PacketUtil.getWorld(), getGameProflie(), getPlayerInteractManager());
    }

    public abstract GameProfile getGameProflie();
    public abstract PlayerInteractManager getPlayerInteractManager();

}
