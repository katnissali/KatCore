package com.katnissali.katcore.Misc;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IrregularRegion extends Region {

    private ArrayList<Location> extraLocs = new ArrayList<>();

    public IrregularRegion(Location loc1, Location loc2){
        super(loc1, loc2);
    }
    public IrregularRegion(Region region){
        super(region);
    }


    public void addLocation(Location... locs){
        extraLocs.addAll(extraLocs);
    }
    public void removeLocation(Location loc){
        extraLocs.add(loc);
    }

    @Override
    public ArrayList<Location> getBlockLocations() {
        ArrayList<Location> locs = (ArrayList<Location>) super.getBlockLocations().clone();
        Collections.addAll(locs, (Location[])extraLocs.toArray());
        return locs;
    }

    @Override
    public boolean isInRegion(final Location loc) {
        if(super.isInRegion(loc)) return super.isInRegion(loc);

        for(Location extraLoc : extraLocs) {
            if (loc.getBlock().getLocation().equals(extraLoc)) {
                return true;
            }
        }
        return false;
    }


    public IrregularRegion merge(Region region){
        IrregularRegion newRegion = new IrregularRegion(region);
        newRegion.addLocation((Location[])region.getBlockLocations().toArray());
        return newRegion;
    }
}