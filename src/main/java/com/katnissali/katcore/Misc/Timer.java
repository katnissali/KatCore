package com.katnissali.katcore.Misc;

import com.katnissali.katcore.Core.Util;
import org.bukkit.Bukkit;

public class Timer {

    private final int time;
    private int timeLeft;
    private boolean paused = false;

    public Timer(int seconds){
        this.time = seconds;
        timeLeft = seconds;
        init();
    }

    private void init(){
            Bukkit.getScheduler().scheduleAsyncRepeatingTask(Util.getMain(), new Runnable() {
            @Override
            public void run() {
                updateTime();
            }
        }, 0L, 20L);
    }

    //  SETTERS
    public void resume(){ paused = false; }
    public void pause(){ paused = true; }
    public void updateTime(){
        if(!paused) {
            timeLeft--;
            if (isFinished())
                onFinish();
        }
    }
    public void reset(){
        timeLeft = time;
    }
    public void onFinish(){}
    public void setTimeLeft(int timeLeft){ this.timeLeft = timeLeft; }

    //  GETTERS
    public int getTime(){ return time; }
    public int getTimeLeft(){ return timeLeft; }
    public boolean isPaused(){ return paused; }
    public boolean isFinished(){ return timeLeft <= 0; }
}
