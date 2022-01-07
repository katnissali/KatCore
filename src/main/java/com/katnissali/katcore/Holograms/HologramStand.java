package com.katnissali.katcore.Holograms;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEvent;

public class HologramStand extends HoloBase {

    private ArmorStand armorStand;
    private String text;

    public HologramStand(Location location, String text, boolean hidden, boolean letPlayersClick){
        super(location, hidden, letPlayersClick);
        this.text = text;
        setLocation(location);
        loadNewStand(false);
        new HologramClickEvent(this);
    }
    public HologramStand(ArmorStand armorStand, boolean letPlayersClick){
        super(armorStand, letPlayersClick);
        this.armorStand = armorStand;
        text = armorStand.getCustomName();
        setHidden(armorStand.isCustomNameVisible());
        new HologramClickEvent(this);
    }

    //  SETUP
    public ArmorStand loadNewStand(boolean eraseOld){
        if(eraseOld && armorStand != null) armorStand.remove();
        if(!isHidden()) {
            armorStand = (ArmorStand) getLocation().getWorld().spawnEntity(getLocation(), EntityType.ARMOR_STAND);
            applySettings();
        }
        return getArmorStand();
    }
    public void applySettings(){
        armorStand.setGravity(false);
        armorStand.setCanPickupItems(false);
        armorStand.setCustomNameVisible(true);
        armorStand.setVisible(false);
        armorStand.setCustomName(text);
    }

    //  UPDATERS
    @Override
    public void update(){
        if(isHidden()){
            armorStand.remove();
            armorStand = null;
            return;
        } else {
            armorStand = loadNewStand(true);
        }
        armorStand.setCustomName(text);
        armorStand.teleport(getLocation());
        applySettings();
    }
    public void setText(String text){
        this.text = text;
        update();
    }

    //  GETTERS
    public String getText(){ return text; }
    public ArmorStand getArmorStand(){ return armorStand; }

}
