package com.katnissali.katcore.Holograms;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hologram extends HoloBase {

    private double lineSpacing = 0.3;

    private List<String> lore = new ArrayList<>();
    private List<HologramStand> stands = new ArrayList<HologramStand>();

    public Hologram(String[] lore, Location location, boolean hidden, boolean letPlayersClick){
        super(location, hidden, letPlayersClick);
        instantiate(Arrays.asList(lore));
    }
    public Hologram(List<String> lore, Location location, boolean hidden, boolean letPlayersClick){
        super(location, hidden, letPlayersClick);
        instantiate(lore);
    }

    public double getLineSpacing(){ return lineSpacing; }
    public void setLineSpacing(double lineSpacing){ this.lineSpacing = lineSpacing; }

    private void instantiate(List<String> lore){
        this.lore = lore;
        //  LOAD STANDS
        for(int i = 0; i < lore.size(); i++){
            String str = lore.get(i);
            Location loc = getLocation().clone();
            loc.setY(loc.getY()-(lineSpacing*i));
            HologramStand stand = new HologramStand(loc, str, isHidden(), letPlayersClick());
            stand.setText(lore.get(i));
            addHolo(stand);
        }

        //  ADJUST HEIGHT
        double difference = getLocation().getY()-getMiddleHeight();
        for(HologramStand stand : stands){
            Location newLoc = stand.getLocation();
            newLoc.setY(newLoc.getY()+difference);
            stand.setLocation(newLoc);
        }
        update();
    }

    public void addHolo(HologramStand holo){ stands.add(holo); }
    public double getMiddleHeight(){
        return (stands.get(0).getLocation().getY() + stands.get(stands.size()-1).getLocation().getY())/2;
    }
    public List<HologramStand> getStands(){ return stands; }
    @Override
    public void update() {
        for(HologramStand stand : stands){
            stand.setHidden(isHidden());
            stand.setLocation(getStandLocation(stand));
            stand.update();
        }
    }
    public Location getStandLocation(HologramStand stand){
        double difference = getLocation().getY()-getMiddleHeight();
        Location loc = stand.getLocation();
        loc.setY(loc.getY()+difference);
        return loc;
    }
}
