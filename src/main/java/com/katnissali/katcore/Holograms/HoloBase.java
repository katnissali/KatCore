package com.katnissali.katcore.Holograms;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.player.PlayerInteractEvent;

abstract public class HoloBase {

    private boolean hidden = false;
    private Location location;
    private boolean letPlayersClick = false;

    public HoloBase(Location location, boolean hidden, boolean letPlayersClick){
        this.location = location;
        this.hidden = hidden;
        this.letPlayersClick = letPlayersClick;
        update();
    }
    public HoloBase(ArmorStand stand, boolean letPlayersClick){
        location = stand.getLocation();
        hidden = stand.isCustomNameVisible();
        this.letPlayersClick = letPlayersClick;
        update();
    }


    public void setHidden(boolean hidden){
        this.hidden = hidden;
        if(this instanceof Hologram){
            for(HologramStand stand : ((Hologram)this).getStands()){
                stand.setHidden(hidden);
            }
        }
        update();
    }
    public boolean isHidden(){
        return hidden; }
    public Location getLocation(){ return location; }
    public void setLocation(Location location){
        this.location = location;

        if(this instanceof Hologram){
            for(HologramStand stand : ((Hologram)this).getStands()){
                stand.setLocation(((Hologram) this).getStandLocation(stand));
            }
        }

        update();
    }
    public abstract void update();
    public void playerInteract(PlayerInteractEvent e){
        e.setCancelled(true);
    }
    public boolean letPlayersClick(){ return letPlayersClick; }
    public void setLetPlayersClick(boolean letPlayersClick){ this.letPlayersClick = letPlayersClick; }
    public void onClick(PlayerInteractEvent e){
        e.setCancelled(letPlayersClick);
    }

}