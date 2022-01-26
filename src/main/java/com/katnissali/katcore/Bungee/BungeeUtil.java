package com.katnissali.katcore.Bungee;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.katnissali.katcore.Core.Util;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BungeeUtil {

    private static ArrayList<String> registeredOutChannels = new ArrayList<>();

    public BungeeUtil(){
        if(isRegistered("BungeeCord")) {
            registerOutgoingChannel("BungeeCord");
        } else {
            Util.printError("Attempted to register bungeecord but it is already registered!");
        }

        if(!Util.getMain().getServer().getOnlineMode()) Util.printError("Trying to load BungeeUtil but server is on online mode. This may cause fatal issues!");
        if(Util.getBungeeUtil() == null) Util.setBungeeUtil(this);
    }

    public static ArrayList<String> getRegisteredOutChannels(){ return (ArrayList<String>) registeredOutChannels.clone(); }
    public static boolean isRegistered(String channel){ return registeredOutChannels.contains(channel); }

    public static void registerOutgoingChannel(String channel){
        Util.getMain().getServer().getMessenger().registerOutgoingPluginChannel(Util.getMain(), channel);
        registeredOutChannels.add(channel);
    }
    public static void sendToServer(Player player, String server){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        player.sendPluginMessage(Util.getMain(), "BungeeCord", out.toByteArray());
    }
    public static boolean sendMessage(String subChannel, String message){
        return sendMessage("BungeeCord", subChannel, message);
    }
    public static boolean sendMessage(String channel, String subChannel, String message){
        Player player = Util.getRandomPlayer();
        if(player == null){
            Util.printError("Attempted to send bungee message but no random player available.");
            return false;
        }

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Forward");
        out.writeUTF("All");
        out.writeUTF(subChannel);

        ByteArrayOutputStream msgBytes = new ByteArrayOutputStream();
        DataOutputStream msgOut = new DataOutputStream(msgBytes);

        try{
            msgOut.writeUTF(message);
            msgOut.writeShort(message.length());
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }

        out.writeShort(msgBytes.toByteArray().length);
        out.write(msgBytes.toByteArray());

        if(!isRegistered(channel)){
            Util.printError("Attempted to send bungee message but channel \"BungeeCord\" is not registered!");
            return false;
        }

        player.sendPluginMessage(Util.getMain(), channel, out.toByteArray());
        return true;
    }
}
