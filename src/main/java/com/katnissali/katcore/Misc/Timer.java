package com.katnissali.katcore.Misc;

import com.katnissali.katcore.Core.Util;
import org.bukkit.Bukkit;

public class Timer {

    private final int time;
    private int timeLeft;
    private boolean paused = false;
    private boolean automaticallyRepeat = false;

    public Timer(int seconds){
        this.time = seconds;
        timeLeft = seconds;
        init();
    }
    public Timer(int seconds, boolean automaticallyRepeat){
        this.time = seconds;
        timeLeft = seconds;
        this.automaticallyRepeat = automaticallyRepeat;
        init();
    }

    private void init(){
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(Util.getMain(), new Runnable() {
            @Override
            public void run() {
                updateTime();
            }
        }, 20L, time);
    }

    //  SETTERS
    public void resume(){ paused = false; }
    public void pause(){ paused = true; }
    public void updateTime(){ if(!paused) timeLeft--; }
    public void reset(){
        timeLeft = time;
    }

    //  GETTERS
    public int getTime(){ return time; }
    public int getTimeLeft(){ return timeLeft; }
    public boolean isPaused(){ return paused; }
    public boolean isFinished(){ return timeLeft <= 0; }
}
