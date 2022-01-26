package com.katnissali.katcore.Misc;

import com.katnissali.katcore.Core.Util;
import net.minecraft.server.v1_16_R3.DoubleBlockFinder;
import org.bukkit.Location;

import java.util.ArrayList;

public class Region {

    private final Location loc1;
    private final Location loc2;

    public Region(Location loc1, Location loc2){
        this.loc1 = loc1.getBlock().getLocation();
        this.loc2 = loc2.getBlock().getLocation();
        if(!loc1.getWorld().equals(loc2.getWorld())){
            Util.printError("Attempted to create region with locations in different worlds!");
        }
    }
    public Region(Region region){
        this.loc1 = region.getLoc1();
        this.loc2 = region.getLoc2();

        if(!loc1.getWorld().equals(loc2.getWorld())){
            Util.printError("Attempted to create region with locations in different worlds!");
        }
    }

    public Location getLoc1(){ return loc1; }
    public Location getLoc2(){ return loc2; }
    
    public ArrayList<Location> getBlockLocations(){
        ArrayList<Location> locs = new ArrayList<>();
        for(int x = getMinX(); x <= getMaxX(); x++) {
            for (int y = getMinY(); y <= getMaxY(); y++) {
                for(int z = getMinZ(); z <= getMaxZ(); z++){
                    locs.add(new Location(loc1.getWorld(), x, y, z).getBlock().getLocation());
                }
            }
        }
        return locs;
    }

    public boolean isInRegion(Location loc){
        return loc.getX() >= getMinX() && loc.getX() <= getMaxX()
                && loc.getY() >= getMinY() && loc.getY() <= getMaxY()
                && loc.getZ() >= getMinZ() && loc.getZ() <= getMaxZ();
    }
    public int getMinY(){
        return (int) Math.min(loc1.getY(), loc2.getY());
    }
    public int getMinX(){
        return (int) Math.min(loc1.getX(), loc2.getX());
    }
    public int getMinZ(){
        return (int) Math.min(loc1.getZ(), loc2.getZ());
    }
    public int getMaxY(){
        return (int) Math.max(loc1.getY(), loc2.getY());
    }
    public int getMaxX(){
        return (int) Math.max(loc1.getX(), loc2.getX());
    }
    public int getMaxZ(){
        return (int) Math.max(loc1.getZ(), loc2.getZ());
    }

}
