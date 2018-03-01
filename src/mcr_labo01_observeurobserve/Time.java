/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcr_labo01_observeurobserve;

/**
 *
 * @author james
 */

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Time implements Subject{
    private Timer t;
    int seconds;
    int minutes;
    int hours;
    LinkedList<Observer> observers;
    boolean run;
    TimerTask tt;
    
    public Time(){
        t = new Timer();
        observers = new LinkedList<Observer>();
        reset();
        run = false;
    }
    
    public void start(){
        if(!run){
            run = true;
            tt = new TimerTask() {
                @Override
                public void run(){
                    increments();
                };
            };
            t.scheduleAtFixedRate(tt, 1000,1000);
        }
    }
    
    public void stop(){
        if(run){
            run = false;
            tt.cancel();
        }
    }
    
    public void reset(){
        seconds = 0;
        minutes = 0;
        hours = 0;
        notifyObserver();;
    }
    
    /*public Timer getTime() {
        return t;
    }*/
    
    public void attach(Observer o){
        observers.add(o);
    }
    
    public void detach(Observer o){
        observers.remove(o);
    }
    
    public void notifyObserver(){
        for(Observer o: observers){
            o.update();
        }
    }
    
    public String toString(){
        return getHours() + "h " + getMinutes() + "m " + getSeconds() + "s";
    }
    
    public int getSeconds(){
        return seconds;
    }
    public int getMinutes(){
        return minutes;
    }
    
    public int getHours(){
        return hours;
    }
    
    public void increments(){
        if(++seconds >= 60){
            if(++minutes >= 60){
                ++hours;
                minutes = 0;
            }
            seconds = 0;
        }
        notifyObserver();
    }
    public boolean isRunning(){
        return run;
    }
}
