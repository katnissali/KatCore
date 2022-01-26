package com.katnissali.katcore.Bungee;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.katnissali.katcore.Core.Util;
import com.katnissali.katcore.Registerables.Registerable;
import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class BungeeListener implements PluginMessageListener, Registerable {

    private final String channel;
    public BungeeListener(){
        channel = "BungeeCord";
    }
    public BungeeListener(String channel){
        this.channel = channel;
    }

    public BungeeListener(boolean register){
        channel = "BungeeCord";
        if(register) register();
    }
    public BungeeListener(String channel, boolean register){
        this.channel = channel;
        if(register) register();
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] info) {
        if(channel == null || channel.equals(this.channel))
        receiveMessage(getSubChannel(info), player, getMessage(info), info);
    }
    private String getSubChannel(byte[] info){
        ByteArrayDataInput input = ByteStreams.newDataInput(info);
        return input.readUTF();
    }
    private String getMessage(byte[] info){
        ByteArrayDataInput input = ByteStreams.newDataInput(info);
        byte[] msgbytes = new byte[input.readShort()];
        input.readFully(msgbytes);

        DataInputStream msgIn = new DataInputStream(new ByteArrayInputStream(msgbytes));

        try{
            return msgIn.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void receiveMessage(String subChannel, Player player, String message, byte[] info){}
    public String getChannel(){ return channel; }

    @Override
    public void register() {
        Util.getMain().getServer().getMessenger().registerIncomingPluginChannel(Util.getMain(), channel, this);
    }
}
