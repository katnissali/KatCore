package com.katnissali.katcore.Registerables;

import com.katnissali.katcore.Core.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public abstract class Cmd implements CommandExecutor, Registerable {

    private String name;
    private TabCompleter tabCompleter = null;

    public Cmd(String name, boolean register){
        this.name = name;
        if(register) register();
    }
    public Cmd(String name){
        this.name = name;
        register();
    }
    public Cmd(String name, TabCompleter tabCompleter, boolean register){
        this.name = name;
        this.tabCompleter = tabCompleter;
        if(register) register();
    }

    //  SETUP
    @Override
    public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);
    @Override
    public void register() {
        PluginCommand cmd = Util.getMain().getCommand(name);
        if(cmd == null) {
            Util.printError("Could not get command " + name + "!");
            return;
        } else {
            cmd.setExecutor(this);
        }
        if(tabCompleter != null) tabCompleter.register();
    }

    public void setTabCompleter(TabCompleter tabCompleter){
        this.tabCompleter = tabCompleter;
        tabCompleter.register(name);
    }
    public TabCompleter getTabCompleter(){ return tabCompleter; }

    //  MISC
    protected void sendMessage(CommandSender sender, String msg){
        if(sender instanceof Player){
            ((Player) sender).sendMessage(msg);
        } else {
            Util.print(msg);
        }
    }
    protected void sendCmdMsg(){
        //  TODO
    }
    protected boolean hasPerm(CommandSender sender, String perm){
        return (!isPlayer(sender)) || sender.hasPermission(perm);
    }
    protected boolean isPlayer(CommandSender sender){ return sender instanceof Player; }
    protected void invalidUsage(CommandSender sender){
        sendMessage(sender, ChatColor.RED + "Invalid usage!");
    }
}
