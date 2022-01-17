package com.katnissali.katcore.Registerables;

import com.katnissali.katcore.Core.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class TabCompleter implements Registerable, org.bukkit.command.TabCompleter {

    private String cmdName;
    public TabCompleter(String cmdName){
        this.cmdName = cmdName;
        register();
    }
    public TabCompleter(){
    }

    @Override
    public void register() {
        Util.getMain().getCommand(cmdName).setTabCompleter(this);
    }
    public void register(String cmdName) {
        this.cmdName = cmdName;
        register();
    }

    @Override
    public abstract List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args);

    public static List<String> format(List<String> list, String[] args){
        return list.stream().filter(a -> a.toLowerCase().startsWith(args[args.length-1].toLowerCase())).collect(Collectors.toList());
    }

}
