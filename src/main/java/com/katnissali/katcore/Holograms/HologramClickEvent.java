package com.katnissali.katcore.Holograms;

import com.katnissali.katcore.Registerables.EventListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class HologramClickEvent {

    private HologramStand stand;

    public HologramClickEvent(HologramStand stand) {
        this.stand = stand;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(false){        //  TODO
            stand.playerInteract(e);
        }

    }

}
